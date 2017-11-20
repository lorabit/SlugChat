package main.java.slugchat.mobile.service;

import main.java.slugchat.mobile.service.implementation.models.MobileService;
import main.java.slugchat.mobile.service.implementation.models.MobileServiceMapperImpl;
import main.java.slugchat.mobile.service.mapper.ClientMapper;
import main.java.slugchat.mobile.service.mapper.LogMapper;
import main.java.slugchat.mobile.service.mapper.ProfileMapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

import java.util.Properties;

import static com.google.inject.name.Names.bindProperties;

public class SlugChatMyBatisModule extends MyBatisModule {

    String jdbcUrl;

    public SlugChatMyBatisModule(String url){
        jdbcUrl = url;
    }

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
        addMapperClass(LogMapper.class);
    }

    protected Properties createTestProperties() {
        Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test");
        myBatisProperties.setProperty("JDBC.schema", "slugchat");
        myBatisProperties.setProperty("JDBC.driver", "com.mysql.cj.jdbc.Driver");
        myBatisProperties.setProperty("JDBC.url", jdbcUrl );
        myBatisProperties.setProperty("JDBC.autoCommit", "true");
        myBatisProperties.setProperty("Pool.PingQuery", "select clientId from tbl_clients where clientId=1");
        myBatisProperties.setProperty("Pool.PingEnabled", "true");
        myBatisProperties.setProperty("Pool.MaximumActiveConnections", "10");
        myBatisProperties.setProperty("Pool.MaximumIdleConnections", "5");
        myBatisProperties.setProperty("Pool.MaximumCheckoutTime", "150000");
        myBatisProperties.setProperty("Pool.MaximumTimeToWait", "500");
        return myBatisProperties;
    }

}
