package main.java.slugchat.api.producer;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import com.google.inject.Provider;
import com.google.inject.Provides;
import main.java.slugchat.api.annotations.ApiExecutorService;
import main.java.slugchat.api.annotations.SongResult;
import main.java.slugchat.api.models.DialogflowWebhookRequest;
import main.java.slugchat.api.models.DialogflowWebhookResponse;
import main.java.slugchat.constants.DialogflowConstants;
import main.java.slugchat.constants.KnowledgeBaseConstants;
import main.java.slugchat.mybatis.domain.Log;
import main.java.slugchat.mybatis.domain.Song;
import main.java.slugchat.mybatis.impl.MobileService;
import org.joda.time.Instant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Random;
import java.util.concurrent.Callable;

public class SongResultProducerModule extends AbstractModule {

    @BindingAnnotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface SongRandom{}

    @BindingAnnotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface SongByTitle{}

    @BindingAnnotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface SelectedSong{}


    private String songUrlPrefix;

    public SongResultProducerModule(String songUrlPrefix){
        this.songUrlPrefix = songUrlPrefix;
    }

    @Override
    protected void configure() {

    }

    @Provides
    @SongResult
    ListenableFuture<DialogflowWebhookResponse> providesSongResult(
            @ApiExecutorService ListeningExecutorService executorService,
            @SelectedSong ListenableFuture<Song> songListenableFuture,
            DialogflowWebhookRequest request,
            MobileService mobileService
    ){
        return executorService.submit(new Callable<DialogflowWebhookResponse>() {
            @Override
            public DialogflowWebhookResponse call() throws Exception {
                Song song = songListenableFuture.get();
                Log log = new Log();
                log.setProfileId(Long.parseLong(request.getSessionId()));
                log.setCreateTime(Instant.now().getMillis());
                log.setLogType(com.kidschat.service.mobile.Log.LogType.PLAY_SONG_VALUE);
                log.setContent(Integer.toString(song.getSongId()));
                mobileService.createLog(log);
                DialogflowWebhookResponse response = new DialogflowWebhookResponse();
                response.setSpeech(ContentFormatUtil.soundUrlToSpeech(songUrlPrefix+song.getSongId()+".mp3"));
                return response;
            }
        });
    }

    @Provides
    @SelectedSong
    ListenableFuture<Song> providesSelectedSong(
            @ApiExecutorService ListeningExecutorService executorService,
            @SongRandom Provider<ListenableFuture<Song>> randomSong,
            @SongByTitle Provider<ListenableFuture<Song>> titleSong
            ){
        return executorService.submit(new Callable<Song>() {
            @Override
            public Song call() throws Exception {
                Song ret = titleSong.get().get();
                if(ret!=null){
                    return ret;
                }
                return randomSong.get().get();
            }
        });
    }

    @Provides
    @SongByTitle
    ListenableFuture<Song> providesSongByTitle(
            @ApiExecutorService ListeningExecutorService executorService,
            DialogflowWebhookRequest webhookRequest,
            MobileService mobileService){
        return executorService.submit(new Callable<Song>() {
            @Override
            public Song call() throws Exception {
                String title = DialogflowUtil.parametersFromRequest(webhookRequest).get(DialogflowConstants.PARAM_SONG_TITLE);
                if(Strings.isNullOrEmpty(title)){
                    return null;
                }
                ImmutableList<Song> songs = mobileService.listSongsByTitle(title);
                Random rand = new Random();
                return songs.get(rand.nextInt(songs.size()));
            }
        });
    }

    @Provides
    @SongRandom
    ListenableFuture<Song> providesSongRandom(
            @ApiExecutorService ListeningExecutorService executorService,
            DialogflowWebhookRequest webhookRequest,
            MobileService mobileService){
        return executorService.submit(new Callable<Song>() {
            @Override
            public Song call() throws Exception {
                Random rand = new Random();
                return mobileService.getSongById(rand.nextInt(KnowledgeBaseConstants.NUMBER_OF_SONGS)+1);
            }
        });
    }

}
