package main.java.slugchat.mobile.service.implementation;

import com.google.inject.Inject;
import com.kidschat.service.mobile.Profile;
import main.java.slugchat.mybatis.impl.MobileService;
import org.joda.time.Instant;

public class CreateProfile {

    @Inject
    private MobileService mobileService;

    public Profile createProfile(Profile profile){
        main.java.slugchat.mybatis.domain.Profile profileWithTimestamp =
                new main.java.slugchat.mybatis.domain.Profile(profile);
        profileWithTimestamp.setCreateTime(Instant.now().getMillis());
        return mobileService.createProfile(profileWithTimestamp).toProto();
    }

}
