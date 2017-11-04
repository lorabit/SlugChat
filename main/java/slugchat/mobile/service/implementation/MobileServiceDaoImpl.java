package main.java.slugchat.mobile.service.implementation;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import main.java.slugchat.mobile.service.dao.ClientDao;
import main.java.slugchat.mobile.service.dao.ProfileDao;
import main.java.slugchat.mobile.service.domain.Client;
import main.java.slugchat.mobile.service.domain.Profile;

public class MobileServiceDaoImpl implements MobileService {


    @Inject
    private ClientDao clientDao;

    @Inject
    private ProfileDao profileDao;

    @Override
    public Client getClientByClientId(int clientId) {
        return this.clientDao.getClient(clientId);
    }

    @Override
    public Client createClient(Client client) {
        return this.clientDao.createClient(client);
    }

    @Override
    public Profile createProfile(Profile profile) {
        return profileDao.createProfile(profile);
    }

    @Override
    public ImmutableList<Profile> listProfileUnderClient(int clientId) {
        return profileDao.listProfileUnderClient(clientId);
    }
}
