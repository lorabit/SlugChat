package main.java.slugchat.mybatis.dao;

import com.google.inject.Inject;
import main.java.slugchat.mybatis.domain.Log;
import main.java.slugchat.mybatis.mapper.LogMapper;
import org.apache.ibatis.session.SqlSession;

public class LogDaoImpl implements LogDao {

    private SqlSession sqlSession;

    @Inject
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public Log createLog(Log log) {
        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
        logMapper.createLog(log);
        return log;
    }
}
