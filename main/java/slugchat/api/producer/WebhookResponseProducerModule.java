package main.java.slugchat.api.producer;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;
import main.java.slugchat.api.annotations.ApiExecutorService;
import main.java.slugchat.api.annotations.PoemResult;
import main.java.slugchat.api.annotations.StoryResult;
import main.java.slugchat.api.annotations.WebhookResponse;
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

    @Override
    protected void configure() {
        install(new PoemResultProducerModule());
        install(new StoryResultProducerModule());
    }

    @Provides
    @WebhookResponse
    ListenableFuture<DialogflowWebhookResponse> providesDialogflowWebhookResponse(
           @ApiExecutorService ListeningExecutorService executorService,
           @PoemResult ListenableFuture<DialogflowWebhookResponse> poemResult,
            @StoryResult ListenableFuture<DialogflowWebhookResponse> storyResult,
            DialogflowWebhookRequest request
            ){
        return executorService.submit(new Callable<DialogflowWebhookResponse>() {
            @Override
            public DialogflowWebhookResponse call() throws Exception {
                if(request.getResult().getMetadata().getIntentName().equals(DialogflowConstants.INTENT_POEM))
                    return poemResult.get();
                if(request.getResult().getMetadata().getIntentName().equals(DialogflowConstants.INTENT_STORY_WITH_TITLE))
                    return storyResult.get();

                DialogflowWebhookResponse defaultResponse = new DialogflowWebhookResponse();
                Random rand = new Random();
                defaultResponse.setSpeech(DEFAULT_RESPONSES.get(rand.nextInt(DEFAULT_RESPONSES.size())));
                return defaultResponse;
            }
        });
    }


}
