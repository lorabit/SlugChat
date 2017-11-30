package main.java.slugchat.mybatis.dao;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import main.java.slugchat.mybatis.domain.Song;
import org.apache.ibatis.session.SqlSession;

public class SongDaoImpl implements SongDao {

    @Inject
    private SqlSession sqlSession;

    @Override
    public Song getSongById(int songId) {
        return (Song) this.sqlSession.selectOne("SongMapper.getSongById",songId);
    }

    @Override
    public ImmutableList<Song> listSongsByTitle(String title) {
        return ImmutableList.copyOf(
                sqlSession.selectList(
                        "SongMapper.listSongsByTitle",title));
    }

}
