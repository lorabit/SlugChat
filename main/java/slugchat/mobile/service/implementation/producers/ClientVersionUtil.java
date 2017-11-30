package main.java.slugchat.mobile.service.implementation.producers;

import com.kidschat.service.mobile.UserRequest;

public class ClientVersionUtil {
    private ClientVersionUtil(){}

    public static boolean supportAudio(UserRequest userRequest){
        if(!userRequest.hasMetaData()){
            return false;
        }
        return true;
    }
}
