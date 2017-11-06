package main.java.slugchat.mobile.service.dao;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import main.java.slugchat.mobile.service.domain.Profile;
import main.java.slugchat.mobile.service.mapper.ProfileMapper;
import org.apache.ibatis.session.SqlSession;

public class ProfileDaoImpl implements ProfileDao{
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
                        "main.java.slugchat.mobile.service.mapper.ProfileMapper.listProfilesUnderClient",clientId));
    }
}
