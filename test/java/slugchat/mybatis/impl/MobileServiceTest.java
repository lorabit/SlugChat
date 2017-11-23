package test.java.slugchat.mybatis.impl;

import com.google.common.collect.ImmutableList;
import com.google.inject.Injector;
import main.java.slugchat.mybatis.SlugChatMyBatisModule;
import main.java.slugchat.mybatis.domain.Client;
import main.java.slugchat.mybatis.domain.Poem;
import main.java.slugchat.mybatis.impl.MobileService;
import main.java.slugchat.mybatis.impl.MobileServiceMapperImpl;
import main.java.slugchat.mybatis.mapper.ClientMapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.name.Names.bindProperties;
import static org.apache.ibatis.io.Resources.getResourceAsReader;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MobileServiceTest {

    private Injector injector;

    private MobileService mobileService;

    @Before
    public void setUp() throws IOException, SQLException{
        this.injector = createInjector(
                new SlugChatMyBatisModule("jdbc:mysql://slugchat-test.cqpr0kxypucj.us-west-2.rds.amazonaws.com/slugchat?user=root&password=password&useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true")
         );

        this.mobileService = this.injector.getInstance(MobileService.class);
    }

    @Test
    public void testFooService() {
        Client client = this.mobileService.getClientByClientId(1L);
        assertNotNull(client);
        assertEquals(1l, (long)client.getClientId());
        assertEquals("test", client.getDeviceToken());

        Client newClient = new Client();
        newClient.setDeviceToken("d1");
        newClient.setCreateTime(1234L);
        newClient = mobileService.createClient(newClient);
        assertNotNull(newClient.getClientId());
        assertEquals(newClient.getDeviceToken(),"d1");
    }

    @Test
    public void testGetPoem(){
        ImmutableList<Poem> poems = mobileService.listPoemsWithAuthor("李白");
        assertTrue(!poems.isEmpty());
    }
}
