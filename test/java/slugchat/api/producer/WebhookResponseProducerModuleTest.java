package test.java.slugchat.api.producer;


import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import main.java.slugchat.api.annotations.WebhookResponse;
import main.java.slugchat.api.models.DialogflowWebhookRequest;
import main.java.slugchat.api.models.DialogflowWebhookResponse;
import main.java.slugchat.api.producer.ApiExecutorServiceProducerModule;
import main.java.slugchat.api.producer.WebhookResponseProducerModule;
import main.java.slugchat.constants.DialogflowConstants;
import main.java.slugchat.mybatis.SlugChatMyBatisModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class WebhookResponseProducerModuleTest {

    @Inject
            @WebhookResponse
    Provider<ListenableFuture<DialogflowWebhookResponse>> responseProvider;

    DialogflowWebhookRequest dialogflowWebhookRequest;


    @Bind
    Provider<DialogflowWebhookRequest> requestProvider = new Provider<DialogflowWebhookRequest>() {
        @Override
        public DialogflowWebhookRequest get() {
            return dialogflowWebhookRequest;
        }
    };

    @Before
    public void setup(){
        Guice.createInjector(
                BoundFieldModule.of(this),
                new SlugChatMyBatisModule("jdbc:mysql://slugchat-test.cqpr0kxypucj.us-west-2.rds.amazonaws.com/slugchat?user=root&password=password&useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"),
                new ApiExecutorServiceProducerModule(),
                new WebhookResponseProducerModule()
        ).injectMembers(this);
    }

    @Test
    public void testPoemWithAuthor() throws Exception{
        dialogflowWebhookRequest = getPoemRequest("", "李白");
        DialogflowWebhookResponse response = responseProvider.get().get();
        System.out.println(response.getSpeech());
        assertTrue(response.getSpeech().indexOf("李白")>=0);
    }

    private DialogflowWebhookRequest getPoemRequest(String title, String author){
        DialogflowWebhookRequest request = new DialogflowWebhookRequest();
        DialogflowWebhookRequest.Result result = new DialogflowWebhookRequest.Result();
        DialogflowWebhookRequest.Result.Metadata metadata = new DialogflowWebhookRequest.Result.Metadata();
        metadata.setIntentName(DialogflowConstants.INTENT_POEM);
        result.setMetadata(metadata);
        Map<String, String> params = new HashMap<>();
        if(!Strings.isNullOrEmpty(title)){
            params.put(DialogflowConstants.PARAM_POEM_TITLE, title);
        }
        if(!Strings.isNullOrEmpty(author)){
            params.put(DialogflowConstants.PARAM_POEM_AUTHOR, author);
        }
        result.setParameters(params);
        request.setResult(result);
        return request;
    }

}
