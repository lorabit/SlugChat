package main.java.slugchat.mobile.service.implementation;

import ai.api.AIDataService;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import com.google.inject.Inject;
import com.kidschat.service.mobile.ChatbotResponse;
import com.kidschat.service.mobile.UserRequest;
import main.java.slugchat.mobile.service.domain.Log;
import org.apache.log4j.Logger;
import org.joda.time.Instant;

/**
 * Created by lorabit on 04/11/2017.
 */
public class GetChatbotResponse {


    static Logger logger = Logger.getLogger(GetChatbotResponse.class);

    @Inject
    private AIDataService aiDataService;

    @Inject
    private MobileService mobileService;

    public ChatbotResponse getChatbotResponse(UserRequest userRequest) throws AIServiceException{

        Log requestLog = new Log();
        requestLog.setProfileId(userRequest.getProfileId());
        requestLog.setCreateTime(Instant.now().getMillis());
        requestLog.setLogType(com.kidschat.service.mobile.Log.LogType.SPEECH_REQUEST_VALUE);
        requestLog.setContent(userRequest.getText());
        mobileService.createLog(requestLog);

        logger.info(userRequest);
                AIRequest request = new AIRequest(userRequest.getText());
        request.setSessionId(Long.toString(userRequest.getProfileId()));
        request.setQuery(userRequest.getText());
        AIResponse aiResponse = aiDataService.request(request);
        ChatbotResponse response = ChatbotResponse.newBuilder()
                .setText(aiResponse.getResult().getFulfillment().getSpeech()).build();
        logger.info(aiResponse);
        logger.info(response);


        Log responseLog = new Log();
        responseLog.setProfileId(userRequest.getProfileId());
        responseLog.setCreateTime(Instant.now().getMillis());
        responseLog.setLogType(com.kidschat.service.mobile.Log.LogType.SPEECH_RESPONSE_VALUE);
        responseLog.setContent(aiResponse.toString());
        mobileService.createLog(responseLog);

        return response;
    }
}
