package main.java.slugchat.mybatis.dao;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import main.java.slugchat.mybatis.domain.Profile;
import main.java.slugchat.mybatis.mapper.ProfileMapper;
import org.apache.ibatis.session.SqlSession;

public class ProfileDaoImpl implements main.java.slugchat.mybatis.dao.ProfileDao {
    private SqlSession sqlSession;

    @Inject
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Profile createProfile(Profile profile) {
        ProfileMapper profileMapper = sqlSession.getMapper(ProfileMapper.class);
        profileMapper.createProfile(profile);
        return profile;
    }

    @Override
    public ImmutableList<Profile> listProfileUnderClient(Long clientId) {
        return ImmutableList.copyOf(
                sqlSession.selectList(
                        "ProfileMapper.listProfilesUnderClient",clientId));
    }
}
