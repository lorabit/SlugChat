package main.java.slugchat.mybatis.dao;

import com.google.common.collect.ImmutableList;
import main.java.slugchat.mybatis.domain.Song;

public interface SongDao {

    Song getSongById(int songId);
    ImmutableList<Song> listSongsByTitle(String title);

}
