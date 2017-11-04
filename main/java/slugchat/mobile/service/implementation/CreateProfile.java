package main.java.slugchat.mobile.service.implementation;

import com.google.inject.Inject;
import com.kidschat.service.mobile.Profile;

public class CreateProfile {

    @Inject
    private MobileService mobileService;

    public Profile createProfile(Profile profile){
        return mobileService.createProfile(new main.java.slugchat.mobile.service.domain.Profile(profile)).toProto();
    }

}
