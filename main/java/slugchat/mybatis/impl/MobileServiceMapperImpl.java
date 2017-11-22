package main.java.slugchat.mybatis.impl;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import main.java.slugchat.mybatis.domain.Client;
import main.java.slugchat.mybatis.domain.Log;
import main.java.slugchat.mybatis.domain.Poem;
import main.java.slugchat.mybatis.domain.Profile;
import main.java.slugchat.mybatis.mapper.ClientMapper;
import main.java.slugchat.mybatis.mapper.LogMapper;
import main.java.slugchat.mybatis.mapper.PoemMapper;
import main.java.slugchat.mybatis.mapper.ProfileMapper;

public class MobileServiceMapperImpl implements MobileService {

    @Inject
    private ClientMapper clientMapper;

    @Inject
    private ProfileMapper profileMapper;

    @Inject
    private LogMapper logMapper;

    @Inject
    private PoemMapper poemMapper;

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

    @Override
    public Log createLog(Log log) {
        this.logMapper.createLog(log);
        return log;
    }

    @Override
    public Poem getPoemById(int poemId) {
        return this.poemMapper.getPoemById(poemId);
    }

    @Override
    public ImmutableList<Poem> listPoemsWithAuthor(String author) {
        return ImmutableList.copyOf(this.poemMapper.listPoemsWithAuthor(author));
    }

    @Override
    public ImmutableList<Poem> listPoemsWithTitle(String title) {
        return ImmutableList.copyOf(this.poemMapper.listPoemsWithTitle(title));
    }

    @Override
    public ImmutableList<Poem> listPoemsWithTitleAndAuthor(String title, String author) {
        Poem poem = new Poem();
        poem.setTitle(title);
        poem.setAuthor(author);
        return ImmutableList.copyOf(this.poemMapper.listPoemsWithTitleAndAuthor(poem));
    }
}
