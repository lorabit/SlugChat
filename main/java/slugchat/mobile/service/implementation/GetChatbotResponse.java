package main.java.slugchat.mobile.service.implementation;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.kidschat.service.mobile.ChatbotResponse;
import com.kidschat.service.mobile.UserRequest;
import main.java.slugchat.mybatis.domain.Log;
import main.java.slugchat.mybatis.impl.MobileService;
import main.java.slugchat.mobile.service.implementation.producers.ChatbotResponseProducerModule;
import main.java.slugchat.mobile.service.implementation.producers.ExecutorServiceModule;
import org.apache.log4j.Logger;
import org.joda.time.Instant;

/**
 * Created by lorabit on 04/11/2017.
 */
public class GetChatbotResponse {


    static Logger logger = Logger.getLogger(GetChatbotResponse.class);

    private MobileService mobileService;

    @Inject
    Provider<ListenableFuture<ChatbotResponse>> chatbotResponseProvider;

    private UserRequest userRequest;
    private Provider<UserRequest> userRequestProvider = new Provider<UserRequest>() {
        @Override
        public UserRequest get() {
            return userRequest;
        }
    };

    public GetChatbotResponse(MobileService mobileService, String dialogflowApikey){
        this.mobileService = mobileService;
        Guice.createInjector(
                new AbstractModule() {
                    @Override
                    protected void configure() {
                        bind(UserRequest.class).toProvider(userRequestProvider);
                    }
                },
                new ExecutorServiceModule(),
                new DialogflowModule(dialogflowApikey),
                new ChatbotResponseProducerModule()
        ).injectMembers(this);
    }

    public ChatbotResponse getChatbotResponse(UserRequest request) throws Exception{

        userRequest = request;
        Log requestLog = new Log();
        requestLog.setProfileId(userRequest.getProfileId());
        requestLog.setCreateTime(Instant.now().getMillis());
        requestLog.setLogType(com.kidschat.service.mobile.Log.LogType.SPEECH_REQUEST_VALUE);
        requestLog.setContent(userRequest.getText());
        mobileService.createLog(requestLog);
        ChatbotResponse response = chatbotResponseProvider.get().get();
        String result = response.getText();
        Log responseLog = new Log();
        responseLog.setProfileId(userRequest.getProfileId());
        responseLog.setCreateTime(Instant.now().getMillis());
        responseLog.setLogType(com.kidschat.service.mobile.Log.LogType.SPEECH_RESPONSE_VALUE);
        responseLog.setContent(result);
        responseLog = mobileService.createLog(responseLog);
        return ChatbotResponse
                .newBuilder()
                .mergeFrom(response)
                .setLogId(responseLog.getLogId())
                .build();
    }
}
