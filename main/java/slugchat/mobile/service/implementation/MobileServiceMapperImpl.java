package main.java.slugchat.mobile.service.implementation;

import com.google.inject.Inject;
import main.java.slugchat.mobile.service.domain.Client;
import main.java.slugchat.mobile.service.mapper.ClientMapper;

public class MobileServiceMapperImpl implements MobileService {

    private ClientMapper clientMapper;

    @Inject
    public void setClientMapper(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    @Override
    public Client getClientByClientId(int clientId) {
        return this.clientMapper.getClient(clientId);
    }
}
