package main.java.slugchat.mybatis.mapper;

import main.java.slugchat.mybatis.domain.Song;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SongMapper {
    @Select("SELECT * FROM tbl_songs WHERE songId=#{songId}")
    Song getSongById(@Param("songId") int songId);

    @Select("SELECT * FROM tbl_songs WHERE title=#{title}")
    List<Song> listSongsByTitle(@Param("title") String title);
}
