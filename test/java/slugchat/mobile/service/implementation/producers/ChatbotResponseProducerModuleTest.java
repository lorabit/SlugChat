package test.java.slugchat.mobile.service.implementation.producers;

import static org.junit.Assert.*;

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
import main.java.slugchat.mobile.service.implementation.producers.ChatbotResponseProducerModule;
import main.java.slugchat.mobile.service.implementation.producers.ExecutorServiceModule;
import main.java.slugchat.mobile.service.implementation.producers.GetBaiduResultProducerModule;
import main.java.slugchat.mobile.service.implementation.producers.GetHttpResponseProducerModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.Executors;

@RunWith(JUnit4.class)
public class ChatbotResponseProducerModuleTest {

    static final String DIALOGFLOW_APIKEY = "360f730cc1034b19864a1cae700ff632";

    private UserRequest userRequest;
    @Bind
    Provider<UserRequest> userRequestProvider = new Provider<UserRequest>() {
        @Override
        public UserRequest get() {
            return userRequest;
        }
    };

    @Inject
    Provider<ListenableFuture<ChatbotResponse>> responseProvider;

    @Before
    public void setup(){
        Guice
                .createInjector(
                        BoundFieldModule.of(this),
                        new ExecutorServiceModule(),
                        new DialogflowModule(DIALOGFLOW_APIKEY),
                        new ChatbotResponseProducerModule()
                )
                .injectMembers(this);
    }

    @Test
    public void testGetBaiduSingleResult() throws Exception{
        userRequest = UserRequest.newBuilder().setText("阿里巴巴的创始人是谁？").setProfileId(1).build();
        assertEquals(responseProvider.get().get().getText(),"马云");
    }

    @Test
    public void testGetBaiduListResult() throws Exception{
        userRequest = UserRequest.newBuilder().setText("谷歌的创始人是谁？").setProfileId(1).build();
        assertEquals(responseProvider.get().get().getText(),"谢尔盖·布林和拉里·佩奇");
    }

    @Test
    public void testDialogflowResult() throws Exception{
        userRequest = UserRequest.newBuilder().setText("你好！").setProfileId(1).build();
        assertNotEquals(responseProvider.get().get().getText(),"我想先休息一下。");
    }



}
