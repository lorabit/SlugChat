package main.java.slugchat.mobile.service.implementation;

import ai.api.AIDataService;
import ai.api.model.AIRequest;
import com.google.inject.Inject;
import com.kidschat.service.mobile.ChatbotResponse;
import com.kidschat.service.mobile.UserRequest;

/**
 * Created by lorabit on 04/11/2017.
 */
public class GetChatbotResponse {


    @Inject
    private AIDataService aiDataService;

    public ChatbotResponse getChatbotResponse(UserRequest userRequest){

        AIRequest request = new AIRequest();
//        aiDataService.

    }
}
