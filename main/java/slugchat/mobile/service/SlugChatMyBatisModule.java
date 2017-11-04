package main.java.slugchat.mobile.service;

import main.java.slugchat.mobile.service.implementation.MobileService;
import main.java.slugchat.mobile.service.implementation.MobileServiceMapperImpl;
import main.java.slugchat.mobile.service.mapper.ClientMapper;
import main.java.slugchat.mobile.service.mapper.ProfileMapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

import java.util.Properties;

import static com.google.inject.name.Names.bindProperties;

public class SlugChatMyBatisModule extends MyBatisModule {

    @Override
    protected void initialize() {
        bindDataSourceProviderType(PooledDataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        addMapperClasses();
        bindProperties(binder(), createTestProperties());
        bind(MobileService.class).to(MobileServiceMapperImpl.class);
    }

    protected void addMapperClasses(){
        addMapperClass(ClientMapper.class);
        addMapperClass(ProfileMapper.class);
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

}
