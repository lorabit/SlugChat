package main.java.slugchat.mobile.service.implementation;

import com.google.inject.Inject;
import main.java.slugchat.mobile.service.dao.ClientDao;
import main.java.slugchat.mobile.service.domain.Client;

public class MobileServiceDaoImpl implements MobileService {


    private ClientDao clientDao;

    @Inject
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public Client getClientByClientId(int clientId) {
        return this.clientDao.getClient(clientId);
    }

    @Override
    public Client createClient(Client client) {
        return this.clientDao.createClient(client);
    }
}
