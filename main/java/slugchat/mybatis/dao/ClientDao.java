package main.java.slugchat.mybatis.dao;

import main.java.slugchat.mybatis.domain.Client;

public interface ClientDao {

    Client getClient(Long clientId);
    Client createClient(Client client);

}
