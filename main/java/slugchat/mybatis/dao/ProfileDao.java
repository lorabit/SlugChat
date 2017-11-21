package main.java.slugchat.mybatis.dao;

import com.google.common.collect.ImmutableList;
import main.java.slugchat.mybatis.domain.Profile;

public interface ProfileDao {

    ImmutableList<Profile> listProfileUnderClient(Long clientId);
    Profile createProfile(Profile profile);

}
