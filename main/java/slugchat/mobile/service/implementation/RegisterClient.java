package main.java.slugchat.mobile.service.implementation;

import com.google.inject.Inject;
import com.kidschat.service.mobile.RegisterClientRequest;
import com.kidschat.service.mobile.RegisterClientResponse;
import main.java.slugchat.mybatis.domain.Client;
import main.java.slugchat.mybatis.impl.MobileService;
import org.joda.time.Instant;

/**
 * Created by lorabit on 02/11/2017.
 */
public class RegisterClient {

    @Inject
    private MobileService mobileService;


    public RegisterClientResponse registerClient(RegisterClientRequest request){
        Client client = new Client();
        client.setCreateTime(Instant.now().getMillis());
        client.setDeviceToken(request.getDeviceToken());
        client = mobileService.createClient(client);
        return RegisterClientResponse.newBuilder().setClientId(client.getClientId()).build();
    }
}
