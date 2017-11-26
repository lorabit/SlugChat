package main.java.slugchat.mobile.service.implementation.producers;

import ai.api.AIDataService;
import ai.api.model.AIEvent;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.google.inject.Provides;
import main.java.slugchat.constants.DialogflowConstants;
import main.java.slugchat.mobile.service.implementation.annotations.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Callable;

public class DialogflowResultProducerModule extends AbstractModule {

    @BindingAnnotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface DialogflowEventName{}

    @Override
    protected void configure() {
    }

    @Provides
    @DialogflowEventName
    String providesEventName(@RequestSpeechText String speech){
        if(DialogflowConstants.EVENT_FROM_COMMAND.containsKey(speech)){
            return DialogflowConstants.EVENT_FROM_COMMAND.get(speech);
        }
        return "";
    }

    @Provides
    @DialogflowResult
    ListenableFuture<String> providesDialogflowResult(
            @MobileExecutorService ListeningExecutorService service,
            AIDataService aiDataService,
            @RequestSpeechText String speech,
            @DialogflowEventName String eventName,
            @RequestProfileId Long profileId){
        return service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                AIRequest request = new AIRequest(speech);
                request.setSessionId(Long.toString(profileId));
                request.setQuery(speech);
                if(!Strings.isNullOrEmpty(eventName)){
                    AIEvent event = new AIEvent(eventName);
                    request.setEvent(event);
                    System.out.println(eventName);
                }
                System.out.println(request);
                AIResponse aiResponse = aiDataService.request(request);
                return aiResponse.getResult().getFulfillment().getSpeech();
            }
        });
    }


}
