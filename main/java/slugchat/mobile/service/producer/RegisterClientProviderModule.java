package main.java.slugchat.mobile.service.producer;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.kidschat.service.mobile.RegisterClientRequest;
import com.kidschat.service.mobile.RegisterClientResponse;
import main.java.slugchat.mobile.service.domain.Client;
import main.java.slugchat.mobile.service.implementation.MobileService;
import org.joda.time.DateTime;
import org.joda.time.Instant;

public class RegisterClientProviderModule extends AbstractModule {

    @Override
    protected void configure() {

    }

    @Provides
    RegisterClientResponse providesRegisterClientResponse(RegisterClientRequest request, MobileService mobileService){
        Client client = new Client();
        client.setCreateTime(Instant.now().getMillis());
        client.setDeviceToken(request.getDeviceToken());
        client = mobileService.createClient(client);
        return RegisterClientResponse.newBuilder().setClientId(client.getClientId()).build();
    }
}
