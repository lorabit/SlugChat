package main.java.slugchat.mobile.service.implementation;

import ai.api.AIDataService;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import com.google.inject.Inject;
import com.kidschat.service.mobile.ChatbotResponse;
import com.kidschat.service.mobile.UserRequest;
import org.apache.log4j.Logger;

/**
 * Created by lorabit on 04/11/2017.
 */
public class GetChatbotResponse {


    static Logger logger = Logger.getLogger(GetChatbotResponse.class);

    @Inject
    private AIDataService aiDataService;

    public ChatbotResponse getChatbotResponse(UserRequest userRequest) throws AIServiceException{
        AIRequest request = new AIRequest();
        request.setQuery(userRequest.getText());
        logger.info(userRequest);
        AIResponse aiResponse = aiDataService.request(request);
        ChatbotResponse response = ChatbotResponse.newBuilder()
                .setText(aiResponse.getResult().getFulfillment().getSpeech()).build();
        logger.info(response);
        return response;
    }
}
