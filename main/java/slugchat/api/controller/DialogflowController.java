package main.java.slugchat.api.controller;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import main.java.slugchat.api.models.DialogflowWebhookRequest;
import main.java.slugchat.api.models.DialogflowWebhookResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * Created by lorabit on 13/11/2017.
 */

@RestController
public class DialogflowController {


    @RequestMapping(
            value = "/dialogflow/webhook",
            method = RequestMethod.POST
    )
//    public DialogflowWebhookResponse webhook(HttpServletRequest request) throws IOException{
//        DialogflowWebhookResponse response = new DialogflowWebhookResponse();
//        response.setSpeech(CharStreams.toString(new InputStreamReader(request.getInputStream(), Charsets.UTF_8)));
//
//        return response;
//    }

    public DialogflowWebhookResponse webhook(@RequestBody Map<String, Object> request) throws IOException{
        DialogflowWebhookResponse response = new DialogflowWebhookResponse();
        Map<String, Object> originalRequest = (Map<String, Object>)request.get("originalRequest");
        Map<String, Object> data = (Map<String, Object>)originalRequest.get("data");
        List<Object> inputs = (List<Object>)data.get("inputs");
        if(inputs.size()>0){
            Map<String, Object> input = (Map<String, Object>)inputs.get(0);
            List<Object> rawInputs = (List<Object>)input.get("raw_inputs");
            if(rawInputs.size()>0){
                Map<String, Object> rawInput = (Map<String, Object>)rawInputs.get(0);
                response.setSpeech("You said: "+rawInput.get("query").toString());
            }
        }

//        response.setSpeech(request.getOriginalRequest().getData().getInputs().get(0).getIntent());
//        response.setSpeech(request.getOriginalRequest().getData().getInputs().get(0).getRaw_inputs().get(0).getQuery());
        return response;
    }
}
