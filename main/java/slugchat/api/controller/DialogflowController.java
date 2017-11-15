package main.java.slugchat.api.controller;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import main.java.slugchat.api.models.DialogflowWebhookRequest;
import main.java.slugchat.api.models.DialogflowWebhookResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @RequestMapping(
            value = "/dialogflow/webhook",
            method = RequestMethod.POST
    )


    public DialogflowWebhookResponse webhook(@RequestBody DialogflowWebhookRequest request) throws IOException{
        DialogflowWebhookResponse response = new DialogflowWebhookResponse();
        response.setSpeech("You just said: "+request.getId());
        return response;
    }

    @RequestMapping(
            value = "/dialogflow/webhook/raw",
            method = RequestMethod.POST
    )
    public DialogflowWebhookResponse webhookRaw(HttpServletRequest request) throws IOException{
        DialogflowWebhookResponse response = new DialogflowWebhookResponse();
        String jsonString = CharStreams.toString(new InputStreamReader(request.getInputStream(), Charsets.UTF_8));
        response.setSpeech(jsonString);
        logger.info(jsonString);
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            logger.info(headerName+":"+request.getHeader(headerName));
        }
        return response;
    }


    @RequestMapping(
            value = "/dialogflow/webhook/map",
            method = RequestMethod.POST
    )
    public DialogflowWebhookResponse webhookMap(@RequestBody Map<String,Object> request) throws IOException{
        DialogflowWebhookResponse response = new DialogflowWebhookResponse();
        response.setSpeech("You just said");
        logger.info(request.toString());
        return response;
    }

}
