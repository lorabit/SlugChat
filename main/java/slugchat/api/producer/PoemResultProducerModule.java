package main.java.slugchat.api.producer;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.google.inject.Provides;
import main.java.slugchat.api.annotations.ApiExecutorService;
import main.java.slugchat.api.annotations.PoemResult;
import main.java.slugchat.api.models.DialogflowWebhookRequest;
import main.java.slugchat.api.models.DialogflowWebhookResponse;
import main.java.slugchat.constants.DialogflowConstants;
import main.java.slugchat.constants.KnowledgeBaseConstants;
import main.java.slugchat.mybatis.dao.PoemDao;
import main.java.slugchat.mybatis.domain.Poem;
import main.java.slugchat.mybatis.impl.MobileService;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

public class PoemResultProducerModule extends AbstractModule {

    private final static ImmutableList<String> NOT_FOUND_RESPONSES = ImmutableList.of(
            "小虫虫不会这首诗",
            "这首诗小虫虫还没学过",
            "小虫虫找不到这首诗"
    );


    @BindingAnnotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface ResultWithAuthor{}

    @BindingAnnotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface ResultWithTitle{}

    @BindingAnnotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface ResultWithTitleAndAuthor{}


    @BindingAnnotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface ResultRandom{}

    @BindingAnnotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface RequestPoem{}



    @Override
    protected void configure() {

    }

    @Provides
    @PoemResult
    ListenableFuture<DialogflowWebhookResponse> providesPoemResult(
            @ApiExecutorService ListeningExecutorService executorService,
            @RequestPoem Poem requestPoem,
            @ResultWithTitle ListenableFuture<ImmutableList<Poem>> resultWithTitle,
            @ResultWithAuthor ListenableFuture<ImmutableList<Poem>> resultWithAuthor,
            @ResultWithTitleAndAuthor ListenableFuture<ImmutableList<Poem>> resultWithTitleAndAuthor,
            @ResultRandom ListenableFuture<ImmutableList<Poem>> resultRandom
    ){
        return executorService.submit(new Callable<DialogflowWebhookResponse>() {
            @Override
            public DialogflowWebhookResponse call() throws Exception {
                Random rand = new Random();
                DialogflowWebhookResponse response = new DialogflowWebhookResponse();
                ImmutableList<Poem> result;
                if(Strings.isNullOrEmpty(requestPoem.getTitle()) &&
                        Strings.isNullOrEmpty(requestPoem.getAuthor())){
                    result = resultRandom.get();
                }else{
                    if(Strings.isNullOrEmpty(requestPoem.getTitle())){
                        result = resultWithAuthor.get();
                    }else{
                        if(Strings.isNullOrEmpty(requestPoem.getAuthor())){
                            result = resultWithTitle.get();
                        }else{
                            result = resultWithTitleAndAuthor.get();
                        }
                    }
                }
                if(result == null || result.size() == 0){
                    response.setSpeech(NOT_FOUND_RESPONSES.get(rand.nextInt(NOT_FOUND_RESPONSES.size())));
                }else{
                    response.setSpeech(PoemUtil.toSpeech(result.get(rand.nextInt(result.size()))));
                }
                return response;
            }
        });
    }

    @Provides
    @ResultWithAuthor
    ListenableFuture<ImmutableList<Poem>> providesResultWithAuthor(
            @ApiExecutorService ListeningExecutorService executorService,
            @RequestPoem Poem requestPoem,
            MobileService mobileService
    ){
        return executorService.submit(new Callable<ImmutableList<Poem>>() {
            @Override
            public ImmutableList<Poem> call() throws Exception {
                return mobileService.listPoemsWithAuthor(requestPoem.getAuthor());
            }
        });
    }


    @Provides
    @ResultWithTitle
    ListenableFuture<ImmutableList<Poem>> providesResultWithTitle(
            @ApiExecutorService ListeningExecutorService executorService,
            @RequestPoem Poem requestPoem,
            MobileService mobileService
    ){
        return executorService.submit(new Callable<ImmutableList<Poem>>() {
            @Override
            public ImmutableList<Poem> call() throws Exception {
                return mobileService.listPoemsWithTitle(requestPoem.getTitle());
            }
        });
    }

    @Provides
    @ResultWithTitleAndAuthor
    ListenableFuture<ImmutableList<Poem>> providesResultWithTitleAndAuthor(
            @ApiExecutorService ListeningExecutorService executorService,
            @RequestPoem Poem requestPoem,
            MobileService mobileService
    ){
        return executorService.submit(new Callable<ImmutableList<Poem>>() {
            @Override
            public ImmutableList<Poem> call() throws Exception {
                return mobileService.listPoemsWithTitleAndAuthor(requestPoem.getTitle(),requestPoem.getAuthor());
            }
        });
    }

    @Provides
    @ResultRandom
    ListenableFuture<ImmutableList<Poem>> providesResultRandomly(
            @ApiExecutorService ListeningExecutorService executorService,
            @RequestPoem Poem requestPoem,
            MobileService mobileService
    ){
        return executorService.submit(new Callable<ImmutableList<Poem>>() {
            @Override
            public ImmutableList<Poem> call() throws Exception {
                Random rand = new Random();
                return ImmutableList.of(mobileService.getPoemById(rand.nextInt(KnowledgeBaseConstants.NUMBER_OF_POEMS)+1));
            }
        });
    }

    @Provides
    @RequestPoem
    Poem providesRequestPoem(DialogflowWebhookRequest request){
//        if(request.getResult().getMetadata().getIntentName().equals("poem")){
            Poem poem = new Poem();
            Map<String, String> params = request.getResult().getParameters();
            if(params.containsKey(DialogflowConstants.PARAM_POEM_TITLE)){
                poem.setTitle(params.get(DialogflowConstants.PARAM_POEM_TITLE));
            }
            if(params.containsKey(DialogflowConstants.PARAM_POEM_AUTHOR)){
                poem.setTitle(params.get(DialogflowConstants.PARAM_POEM_AUTHOR));
            }
            return poem;
//        }
//        return null;
    }

}
