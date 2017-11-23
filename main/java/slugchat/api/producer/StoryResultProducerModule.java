package main.java.slugchat.api.producer;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import main.java.slugchat.api.annotations.ApiExecutorService;
import main.java.slugchat.api.annotations.StoryResult;
import main.java.slugchat.api.models.DialogflowWebhookRequest;
import main.java.slugchat.api.models.DialogflowWebhookResponse;
import main.java.slugchat.constants.DialogflowConstants;
import main.java.slugchat.mybatis.domain.Story;
import main.java.slugchat.mybatis.impl.MobileService;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

public class StoryResultProducerModule extends AbstractModule {

    private static final ImmutableList<String> DEFAULT_RESPONSES =
            ImmutableList.of(
                    "这个故事小虫虫不会讲",
                    "小虫虫可以给你讲另外一个故事吗?"
            );

    @Override
    protected void configure() {
    }

    @Provides
    @StoryResult
    ListenableFuture<DialogflowWebhookResponse> providesStoryResult(
            @ApiExecutorService ListeningExecutorService executorService,
            DialogflowWebhookRequest request,
            MobileService mobileService
            ){
        return executorService.submit(new Callable<DialogflowWebhookResponse>() {
            @Override
            public DialogflowWebhookResponse call() throws Exception {
                Map<String, String> params = request.getResult().getParameters();
                DialogflowWebhookResponse response = new DialogflowWebhookResponse();
                Random rand = new Random();
                if(params.containsKey(DialogflowConstants.PARAM_STORY_TITLE)) {
                    ImmutableList<Story> stories =  mobileService
                            .listStoriesByEntityName(params.get(DialogflowConstants.PARAM_STORY_TITLE));
                    response.setSpeech(
                            ContentFormatUtil.storyToSpeech(
                                    stories.get(rand.nextInt(stories.size()))
                            )
                    );
                }else{
                    response.setSpeech(DEFAULT_RESPONSES.get(rand.nextInt(DEFAULT_RESPONSES.size())));
                }
                return response;
            }
        });
    }
}
