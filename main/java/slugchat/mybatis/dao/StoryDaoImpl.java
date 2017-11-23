package main.java.slugchat.mybatis.dao;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import main.java.slugchat.mybatis.domain.Story;
import org.apache.ibatis.session.SqlSession;

public class StoryDaoImpl implements StoryDao {

    @Inject
    private SqlSession sqlSession;

    @Override
    public ImmutableList<Story> listStoriesByEntityName(String entityName){
        return ImmutableList.copyOf(
                sqlSession.selectList("StoryMapper.listStoriesByEntityName",entityName));
    }
}
