package main.java.slugchat.mobile.service.dao;

import com.google.common.collect.ImmutableList;
import main.java.slugchat.mobile.service.domain.Profile;

public interface ProfileDao {

    ImmutableList<Profile> listProfileUnderClient(Long clientId);
    Profile createProfile(Profile profile);

}