package main.java.slugchat.mobile.service.dao;

import main.java.slugchat.mobile.service.domain.Client;

public interface ClientDao {

    Client getClient(Long clientId);
    Client createClient(Client client);

}
