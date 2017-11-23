package main.java.slugchat.mybatis.impl;

import com.google.common.collect.ImmutableList;
import main.java.slugchat.mybatis.domain.*;

public interface MobileService {

    Client getClientByClientId(Long clientId);
    Client createClient(Client client);


    Profile createProfile(Profile profile);
    ImmutableList<Profile> listProfileUnderClient(Long clientId);

    Log createLog(Log log);

    Poem getPoemById(int poemId);
    ImmutableList<Poem> listPoemsWithAuthor(String author);
    ImmutableList<Poem> listPoemsWithTitle(String title);
    ImmutableList<Poem> listPoemsWithTitleAndAuthor(String title, String author);



    ImmutableList<Story> listStoriesByEntityName(String entityName);
}
