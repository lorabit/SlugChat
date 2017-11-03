package main.java.slugchat.mobile.service.dao;

import com.google.inject.Inject;
import main.java.slugchat.mobile.service.domain.Client;
import org.apache.ibatis.session.SqlSession;

public class ClientDaoImpl implements ClientDao {

    private SqlSession sqlSession;

    @Inject
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Client getClient(int clientId) {
        return (Client) this.sqlSession.selectOne("main.java.slugchat.mobile.service.mapper.ClientMapper.getClient",clientId);
    }
}
