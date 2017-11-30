package main.java.slugchat.api.producer;

import com.google.common.collect.ImmutableMap;
import main.java.slugchat.api.models.DialogflowWebhookRequest;

import java.util.HashMap;
import java.util.Map;

public class DialogflowUtil {
    private DialogflowUtil(){}

    public static ImmutableMap<String, String> parametersFromRequest(DialogflowWebhookRequest request){
        return ImmutableMap.copyOf(request.getResult().getParameters());
    }
}
