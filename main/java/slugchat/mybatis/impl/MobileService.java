package main.java.slugchat.mybatis.impl;

import com.google.common.collect.ImmutableList;
import main.java.slugchat.mybatis.domain.Client;
import main.java.slugchat.mybatis.domain.Log;
import main.java.slugchat.mybatis.domain.Profile;

public interface MobileService {

    Client getClientByClientId(Long clientId);
    Client createClient(Client client);


    Profile createProfile(Profile profile);
    ImmutableList<Profile> listProfileUnderClient(Long clientId);

    Log createLog(Log log);
}
