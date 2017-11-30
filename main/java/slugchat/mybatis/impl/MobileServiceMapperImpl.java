package main.java.slugchat.mybatis.impl;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import main.java.slugchat.mybatis.domain.*;
import main.java.slugchat.mybatis.mapper.*;

public class MobileServiceMapperImpl implements MobileService {

    @Inject
    private ClientMapper clientMapper;

    @Inject
    private ProfileMapper profileMapper;

    @Inject
    private LogMapper logMapper;

    @Inject
    private PoemMapper poemMapper;

    @Inject
    private StoryMapper storyMapper;

    @Inject
    private SongMapper songMapper;

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

    @Override
    public ImmutableList<Story> listStoriesByEntityName(String entityName) {
        return ImmutableList.copyOf(storyMapper.listStoriesByEntityName(entityName));
    }

    @Override
    public Song getSongById(int songId) {
        return this.songMapper.getSongById(songId);
    }

    @Override
    public ImmutableList<Song> listSongsByTitle(String title) {
        return ImmutableList.copyOf(this.songMapper.listSongsByTitle(title));
    }
}
