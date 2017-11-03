package test.java.slugchat.mobile.service;

import com.google.inject.Injector;
import main.java.slugchat.mobile.service.domain.Client;
import main.java.slugchat.mobile.service.implementation.MobileService;
import main.java.slugchat.mobile.service.implementation.MobileServiceMapperImpl;
import main.java.slugchat.mobile.service.mapper.ClientMapper;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.name.Names.bindProperties;
import static org.apache.ibatis.io.Resources.getResourceAsReader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class MobileServiceTest {

    private Injector injector;

    private MobileService mobileService;

    @Before
    public void setUp() throws IOException, SQLException{
        this.injector = createInjector(new MyBatisModule() {

            @Override
            protected void initialize() {

                bindDataSourceProviderType(PooledDataSourceProvider.class);
                bindTransactionFactoryType(JdbcTransactionFactory.class);
                addMapperClass(ClientMapper.class);


                bindProperties(binder(), createTestProperties());
                bind(MobileService.class).to(MobileServiceMapperImpl.class);
            }

        });

        // prepare the test db
//        Environment environment = this.injector.getInstance(SqlSessionFactory.class).getConfiguration().getEnvironment();
//        DataSource dataSource = environment.getDataSource();
//        ScriptRunner runner = new ScriptRunner(dataSource.getConnection());
//        runner.setAutoCommit(true);
//        runner.setStopOnError(true);
//        runner.runScript(getResourceAsReader("org/mybatis/guice/sample/db/database-schema.sql"));
//        runner.runScript(getResourceAsReader("org/mybatis/guice/sample/db/database-test-data.sql"));
//        runner.closeConnection();

        this.mobileService = this.injector.getInstance(MobileService.class);
    }

    protected static Properties createTestProperties() {
        Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test");
        myBatisProperties.setProperty("JDBC.schema", "slugchat");
        myBatisProperties.setProperty("JDBC.driver", "com.mysql.cj.jdbc.Driver");
        myBatisProperties.setProperty("JDBC.url", "jdbc:mysql://slugchat-test.cqpr0kxypucj.us-west-2.rds.amazonaws.com/slugchat?" +
                "user=root&password=password");
//        myBatisProperties.setProperty("JDBC.username", "root");
//        myBatisProperties.setProperty("JDBC.password", "password");
        myBatisProperties.setProperty("JDBC.autoCommit", "false");
        return myBatisProperties;
    }

    @Test
    public void testFooService() {
        Client client = this.mobileService.getClientByClientId(1);
        assertNotNull(client);
        assertEquals(1, client.getId());
        assertEquals("test", client.getDevice_token());
    }
}
