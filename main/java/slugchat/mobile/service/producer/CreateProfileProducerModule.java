package main.java.slugchat.mobile.service.producer;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.kidschat.service.mobile.Profile;
import main.java.slugchat.mobile.service.implementation.MobileService;

public class CreateProfileProducerModule extends AbstractModule{

    @Inject
    private MobileService service;

    @Override
    protected void configure() {

    }

    @Provides
    Profile providesProfile(Profile profile){
        return profile;
    }


}
