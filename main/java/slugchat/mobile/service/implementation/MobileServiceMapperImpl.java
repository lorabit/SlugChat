package main.java.slugchat.mobile.service.implementation;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import main.java.slugchat.mobile.service.domain.Client;
import main.java.slugchat.mobile.service.domain.Profile;
import main.java.slugchat.mobile.service.mapper.ClientMapper;
import main.java.slugchat.mobile.service.mapper.ProfileMapper;

public class MobileServiceMapperImpl implements MobileService {

    @Inject
    private ClientMapper clientMapper;

    @Inject
    private ProfileMapper profileMapper;

//    @Inject
//    public void setClientMapper(ClientMapper clientMapper) {
//        this.clientMapper = clientMapper;
//    }

    @Override
    public Client getClientByClientId(Long clientId) {
        return this.clientMapper.getClient(clientId);
    }

    @Override
    public Client createClient(Client client) {
        this.clientMapper.createClient(client);
        return client;
    }

    @Override
    public Profile createProfile(Profile profile) {
        profileMapper.createProfile(profile);
        return profile;
    }

    @Override
    public ImmutableList<Profile> listProfileUnderClient(Long clientId) {
        return ImmutableList.copyOf(profileMapper.listProfilesUnderClient(clientId));
    }
}
