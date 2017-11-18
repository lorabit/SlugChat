package main.java.slugchat.mobile.service.implementation.producers;

import ai.api.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import main.java.slugchat.mobile.service.implementation.annotations.*;

import java.util.concurrent.Callable;

public class DialogflowResultProducerModule extends AbstractModule {


//    @Inject
//    private AIDataService aiDataService;


    @Override
    protected void configure() {
    }

    @Provides
    @DialogflowResult
    ListenableFuture<String> providesDialogflowResult(
            @MobileExecutorService ListeningExecutorService service,
            AIDataService aiDataService,
            @RequestSpeechText String speech,
            @RequestProfileId Long profileId){
        return service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                AIRequest request = new AIRequest(speech);
                request.setSessionId(Long.toString(profileId));
                request.setQuery(speech);

                System.out.println(aiDataService==null);
                AIResponse aiResponse = aiDataService.request(request);
                System.out.println(aiResponse.toString());
                return aiResponse.getResult().getFulfillment().getSpeech();
            }
        });
    }


}
