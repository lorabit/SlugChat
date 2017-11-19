package test.java.slugchat.mobile.service.implementation.producers;

import static org.junit.Assert.*;

import ai.api.AIDataService;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import com.kidschat.service.mobile.ChatbotResponse;
import com.kidschat.service.mobile.UserRequest;
import main.java.slugchat.mobile.service.implementation.DialogflowModule;
import main.java.slugchat.mobile.service.implementation.annotations.*;
import main.java.slugchat.mobile.service.implementation.producers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.Executors;

@RunWith(JUnit4.class)
public class DialogflowResultProducerModuleTest {

    static final String DIALOGFLOW_APIKEY = "360f730cc1034b19864a1cae700ff632";

    private String userRequest;
    @Bind
    @RequestSpeechText
    Provider<String> userRequestProvider = new Provider<String>() {
        @Override
        public String get() {
            return userRequest;
        }
    };

    @Bind
    @RequestProfileId
    Long profileId = 1l;

    @Inject
    @DialogflowResult
    Provider<ListenableFuture<String>> responseProvider;

    @Inject
    Provider<AIDataService> aiDataServiceProvider;

    @Before
    public void setup(){
        Guice
                .createInjector(
                        BoundFieldModule.of(this),
                        new ExecutorServiceModule(),
                        new DialogflowModule(DIALOGFLOW_APIKEY),
                        new DialogflowResultProducerModule()
                )
                .injectMembers(this);
    }

    @Test
    public void testAiDataService() throws Exception{
        assertNotNull(aiDataServiceProvider.get());
    }

    @Test
    public void testDialogflowResult() throws Exception{
        userRequest = "你好！";
        assertNotEquals(responseProvider.get().get(),"");
    }

    



}
