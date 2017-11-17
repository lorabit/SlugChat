package test.java.slugchat.mobile.service.implementation.producers;

import static org.junit.Assert.*;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import main.java.slugchat.mobile.service.implementation.annotations.BaiduResult;
import main.java.slugchat.mobile.service.implementation.annotations.RequestSpeechText;
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


    @Bind
    @RequestSpeechText
    String query = "阿里巴巴的创始人是谁？";

    @Bind
    ListeningExecutorService listeningExecutorService =
            MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

    @Inject
    @BaiduResult
    Provider<ListenableFuture<String>> baiduResultProvider;

    @Before
    public void setup(){
        Guice
                .createInjector(
                        BoundFieldModule.of(this),
//                        new ExecutorServiceModule(),
                        new GetBaiduResultProducerModule()
                )
                .injectMembers(this);
    }

    @Test
    public void testGetBaiduResult() throws Exception{
        assertEquals(baiduResultProvider.get().get(),"马云");
    }
}
