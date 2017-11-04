package main.java.slugchat.mobile.service.implementation;

import main.java.slugchat.mobile.service.domain.Client;

public interface MobileService {

    Client getClientByClientId(int clientId);
    Client createClient(Client client);
}
