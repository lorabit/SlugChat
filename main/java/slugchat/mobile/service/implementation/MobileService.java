package main.java.slugchat.mobile.service.implementation;

import com.google.common.collect.ImmutableList;
import main.java.slugchat.mobile.service.domain.Client;
import main.java.slugchat.mobile.service.domain.Profile;

public interface MobileService {

    Client getClientByClientId(int clientId);
    Client createClient(Client client);


    Profile createProfile(Profile profile);
    ImmutableList<Profile> listProfileUnderClient(int clientId);
}
