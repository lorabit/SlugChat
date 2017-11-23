package main.java.slugchat.mobile.service.implementation;

import com.google.inject.Inject;
import com.kidschat.service.mobile.Profile;
import main.java.slugchat.constants.ExperimentConstants;
import main.java.slugchat.mybatis.impl.MobileService;
import org.joda.time.Instant;

import java.util.Random;

public class CreateProfile {

    @Inject
    private MobileService mobileService;

    static Random rand = new Random();

    public Profile createProfile(Profile profile){
        main.java.slugchat.mybatis.domain.Profile profileWithTimestamp =
                new main.java.slugchat.mybatis.domain.Profile(profile);
        profileWithTimestamp.setCreateTime(Instant.now().getMillis());
        profileWithTimestamp.setBucket(rand.nextInt(ExperimentConstants.NUM_BUCKETS));
        return mobileService.createProfile(profileWithTimestamp).toProto();
    }

}
