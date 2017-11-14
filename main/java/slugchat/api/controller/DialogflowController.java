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

    public DialogflowWebhookResponse webhook(@RequestBody DialogflowWebhookRequest request) throws IOException{
        DialogflowWebhookResponse response = new DialogflowWebhookResponse();
//        response.setSpeech(request.getOriginalRequest().getData().getInputs().get(0).getIntent());
//        response.setSpeech(request.getOriginalRequest().getData().getInputs().get(0).getRaw_inputs().get(0).getQuery());
        return response;
    }
}
