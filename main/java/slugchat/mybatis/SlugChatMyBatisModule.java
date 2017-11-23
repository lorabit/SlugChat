package main.java.slugchat.mybatis;

import main.java.slugchat.mybatis.impl.MobileService;
import main.java.slugchat.mybatis.impl.MobileServiceMapperImpl;
import main.java.slugchat.mybatis.mapper.*;
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
        addMapperClass(PoemMapper.class);
        addMapperClass(StoryMapper.class);
    }

    protected Properties createTestProperties() {
        Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test");
        myBatisProperties.setProperty("JDBC.schema", "slugchat");
        myBatisProperties.setProperty("JDBC.driver", "com.mysql.cj.jdbc.Driver");
        myBatisProperties.setProperty("JDBC.url", jdbcUrl );
        myBatisProperties.setProperty("JDBC.autoCommit", "true");
        myBatisProperties.setProperty("mybatis.pooled.pingQuery", "select clientId from tbl_clients where clientId=1");
        myBatisProperties.setProperty("mybatis.pooled.pingEnabled", "true");
        myBatisProperties.setProperty("mybatis.pooled.maximumActiveConnections", "10");
        myBatisProperties.setProperty("mybatis.pooled.maximumIdleConnections", "5");
        myBatisProperties.setProperty("mybatis.pooled.maximumCheckoutTime", "150000");
        myBatisProperties.setProperty("mybatis.pooled.timeToWait", "500");
        return myBatisProperties;
    }

}
