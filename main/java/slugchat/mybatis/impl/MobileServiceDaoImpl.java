package main.java.slugchat.mybatis.impl;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import main.java.slugchat.mybatis.dao.ClientDao;
import main.java.slugchat.mybatis.dao.LogDao;
import main.java.slugchat.mybatis.dao.ProfileDao;
import main.java.slugchat.mybatis.domain.Client;
import main.java.slugchat.mybatis.domain.Log;
import main.java.slugchat.mybatis.domain.Profile;

public class MobileServiceDaoImpl implements MobileService {


    @Inject
    private ClientDao clientDao;

    @Inject
    private ProfileDao profileDao;

    @Inject
    private LogDao logDao;

    @Override
    public Client getClientByClientId(Long clientId) {
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
    public ImmutableList<Profile> listProfileUnderClient(Long clientId) {
        return profileDao.listProfileUnderClient(clientId);
    }

    @Override
    public Log createLog(Log log) {
        return this.logDao.createLog(log);
    }
}
