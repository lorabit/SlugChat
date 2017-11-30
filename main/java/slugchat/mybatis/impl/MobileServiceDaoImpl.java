package main.java.slugchat.mybatis.impl;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import main.java.slugchat.mybatis.dao.*;
import main.java.slugchat.mybatis.domain.*;

public class MobileServiceDaoImpl implements MobileService {


    @Inject
    private ClientDao clientDao;

    @Inject
    private ProfileDao profileDao;

    @Inject
    private LogDao logDao;

    @Inject
    private PoemDao poemDao;

    @Inject
    private StoryDao storyDao;

    @Inject
    private SongDao songDao;

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


    @Override
    public Poem getPoemById(int poemId) {
        return this.poemDao.getPoemById(poemId);
    }

    @Override
    public ImmutableList<Poem> listPoemsWithTitleAndAuthor(String title, String author) {
        return this.poemDao.listPoemsWithTitleAndAuthor(title,author);
    }

    @Override
    public ImmutableList<Poem> listPoemsWithTitle(String title) {
        return this.poemDao.listPoemsWithTitle(title);
    }

    @Override
    public ImmutableList<Poem> listPoemsWithAuthor(String author) {
        return this.poemDao.listPoemsWithAuthor(author);
    }

    @Override
    public ImmutableList<Story> listStoriesByEntityName(String entityName) {
        return this.storyDao.listStoriesByEntityName(entityName);
    }

    @Override
    public Song getSongById(int songId) {
        return this.songDao.getSongById(songId);
    }

    @Override
    public ImmutableList<Song> listSongsByTitle(String title) {
        return this.songDao.listSongsByTitle(title);
    }
}
