package main.java.slugchat.api.producer;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;
import main.java.slugchat.api.annotations.*;
import main.java.slugchat.api.models.DialogflowWebhookRequest;
import main.java.slugchat.api.models.DialogflowWebhookResponse;
import main.java.slugchat.constants.DialogflowConstants;
import main.java.slugchat.mybatis.SlugChatMyBatisModule;

import java.util.Random;
import java.util.concurrent.Callable;

public class WebhookResponseProducerModule extends AbstractModule{

    private final static ImmutableList<String> DEFAULT_RESPONSES = ImmutableList.of(
            "这个小虫虫不知道",
            "小虫虫思考了很久还是不知道",
            "这道题小虫虫不会做"
    );

    private String storyApiUrl;
    private String songUrlPrefix;

    public WebhookResponseProducerModule(String storyApiUrl, String songUrlPrefix){
        this.storyApiUrl = storyApiUrl;
        this.songUrlPrefix = songUrlPrefix;
    }

    @Override
    protected void configure() {
        install(new PoemResultProducerModule());
        install(new StoryResultProducerModule());
        install(new StoryApiResponseProducerModule(storyApiUrl));
        install(new SongResultProducerModule(songUrlPrefix));
    }

    @Provides
    @WebhookResponse
    ListenableFuture<DialogflowWebhookResponse> providesDialogflowWebhookResponse(
           @PoemResult Provider<ListenableFuture<DialogflowWebhookResponse>> poemResult,
            @StoryResult Provider<ListenableFuture<DialogflowWebhookResponse>> storyResult,
            @StoryApiResponse Provider<ListenableFuture<DialogflowWebhookResponse>> storyApiResult,
            @SongResult Provider<ListenableFuture<DialogflowWebhookResponse>> songResult,
            DialogflowWebhookRequest request
            ){
        if(request.getResult().getMetadata().getIntentName().equals(DialogflowConstants.INTENT_POEM))
            return poemResult.get();
        if(request.getResult().getMetadata().getIntentName().equals(DialogflowConstants.INTENT_STORY))
            return storyApiResult.get();
        if(request.getResult().getMetadata().getIntentName().equals(DialogflowConstants.INTENT_STORY_WITH_TITLE)) {
            if(request.getResult().getParameters().containsKey(DialogflowConstants.PARAM_STORY_TITLE) &&
                    Strings.isNullOrEmpty(request.getResult().getParameters().get(DialogflowConstants.PARAM_STORY_TITLE))){
                return storyApiResult.get();
            }
            return storyResult.get();
        }
        if (request.getResult().getMetadata().getIntentName().equals(DialogflowConstants.INTENT_SONG)) {
            return songResult.get();
        }
        if (request.getResult().getMetadata().getIntentName().equals(DialogflowConstants.INTENT_SONG_WITH_TITLE)) {
            return songResult.get();
        }
        DialogflowWebhookResponse defaultResponse = new DialogflowWebhookResponse();
        Random rand = new Random();
        defaultResponse.setSpeech(DEFAULT_RESPONSES.get(rand.nextInt(DEFAULT_RESPONSES.size())));
        return Futures.immediateFuture(defaultResponse);
    }


}
