package main.java.slugchat.mybatis.dao;

import com.google.inject.Inject;
import main.java.slugchat.mybatis.domain.Client;
import main.java.slugchat.mybatis.mapper.ClientMapper;
import org.apache.ibatis.session.SqlSession;

public class ClientDaoImpl implements ClientDao {

    private SqlSession sqlSession;

    @Inject
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Client getClient(Long clientId) {
        return (Client) this.sqlSession.selectOne("ClientMapper.getClient",clientId);
    }


    @Override
    public Client createClient(Client client) {
        ClientMapper clientMapper = sqlSession.getMapper(ClientMapper.class);
        clientMapper.createClient(client);
        return client;
    }
}
