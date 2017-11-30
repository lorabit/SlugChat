package main.java.slugchat.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Provider;
import main.java.slugchat.api.annotations.RawRequest;
import main.java.slugchat.api.annotations.WebhookResponse;
import main.java.slugchat.api.models.DialogflowWebhookRequest;
import main.java.slugchat.api.models.DialogflowWebhookResponse;
import main.java.slugchat.api.producer.ApiExecutorServiceProducerModule;
import main.java.slugchat.api.producer.WebhookResponseProducerModule;
import main.java.slugchat.mybatis.SlugChatMyBatisModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created by lorabit on 13/11/2017.
 */

@RestController
public class DialogflowController {

    private static final Logger logger = LoggerFactory.getLogger(DialogflowController.class);

    @Inject
    @WebhookResponse
    Provider<ListenableFuture<DialogflowWebhookResponse>> responseProvider;

    DialogflowWebhookRequest userRequest;

    Provider<DialogflowWebhookRequest> requestProvider = new Provider<DialogflowWebhookRequest>() {
        @Override
        public DialogflowWebhookRequest get() {
            return userRequest;
        }
    };

    String rawRequest;

    @RawRequest
    Provider<String> rawRequestProvider = new Provider<String>() {
        @Override
        public String get() {
            return rawRequest;
        }
    };


    @javax.inject.Inject
    public DialogflowController(
            @Value("${db.url}") String dbUrl,
            @Value("${api.story.url}") String storyApiUrl,
            @Value("${song.urlPrefix}") String songUrlPrefix){
        Guice.createInjector(
                new AbstractModule() {
                    @Override
                    protected void configure() {
                        bind(DialogflowWebhookRequest.class).toProvider(requestProvider);
                        bind(String.class).annotatedWith(RawRequest.class).toProvider(rawRequestProvider);
                    }
                },
        new ApiExecutorServiceProducerModule(),
                new SlugChatMyBatisModule(dbUrl),
                new WebhookResponseProducerModule(storyApiUrl, songUrlPrefix)
                )
                .injectMembers(this);
    }

    @RequestMapping(
            value = "/dialogflow/webhook/raw",
            method = RequestMethod.POST
    )
    public DialogflowWebhookResponse webhookRaw(HttpServletRequest request) throws Exception{
        String jsonString = CharStreams.toString(new InputStreamReader(request.getInputStream(), Charsets.UTF_8));
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(jsonString);
        rawRequest = jsonString;
        userRequest = mapper.readValue(jsonString,DialogflowWebhookRequest.class);
        return responseProvider.get().get();
    }


//    @RequestMapping(
//            value = "/dialogflow/webhook/map",
//            method = RequestMethod.POST
//    )
//    public DialogflowWebhookResponse webhookMap(@RequestBody Map<String,Object> request){
//        DialogflowWebhookResponse response = new DialogflowWebhookResponse();
//        response.setSpeech("You just said");
//        logger.info(request.toString());
//        return response;
//    }

}
