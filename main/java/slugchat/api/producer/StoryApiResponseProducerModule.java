package main.java.slugchat.api.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import main.java.slugchat.api.annotations.ApiExecutorService;
import main.java.slugchat.api.annotations.RawRequest;
import main.java.slugchat.api.annotations.StoryApiResponse;
import main.java.slugchat.api.models.DialogflowWebhookRequest;
import main.java.slugchat.api.models.DialogflowWebhookResponse;

import java.util.concurrent.Callable;

public class StoryApiResponseProducerModule extends AbstractModule {

    private String url;

    public StoryApiResponseProducerModule(String url){
        this.url = url;
    }


    @Override
    protected void configure() {

    }

    @Provides
    @StoryApiResponse
    ListenableFuture<DialogflowWebhookResponse> providesStoryApiResponse(
            @ApiExecutorService ListeningExecutorService executorService,
            @RawRequest String rawRequest
    ){
        return executorService.submit(new Callable<DialogflowWebhookResponse>() {
            @Override
            public DialogflowWebhookResponse call() throws Exception {
                System.out.println("Calling story api");
                String response = HttpClientUtil.post(url, rawRequest);
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(response, DialogflowWebhookResponse.class);
            }
        });
    }


}
