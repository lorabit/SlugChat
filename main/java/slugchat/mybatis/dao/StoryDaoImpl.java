package main.java.slugchat.mybatis.dao;

import com.google.inject.Inject;
import main.java.slugchat.mybatis.domain.Story;
import org.apache.ibatis.session.SqlSession;

public class StoryDaoImpl implements StoryDao {

    @Inject
    private SqlSession sqlSession;

    @Override
    public Story getStoryByEntityName(String entityName) {
        return (Story) this.sqlSession.selectOne("StoryMapper.getStoryByEntityName",entityName);
    }
}
