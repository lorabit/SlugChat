package main.java.slugchat.mobile.service.implementation;

import com.google.inject.*;
import com.google.inject.name.Names;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import java.util.Properties;

/**
 * Created by lorabit on 02/11/2017.
 */
@Singleton
public class DbSessionProducerModule extends AbstractModule {

    @Override
    protected void configure() {
        Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test");
        myBatisProperties.setProperty("JDBC.schema", "mybatis-guice_TEST");
        myBatisProperties.setProperty("derby.create", "true");
        myBatisProperties.setProperty("JDBC.username", "sa");
        myBatisProperties.setProperty("JDBC.password", "");
        myBatisProperties.setProperty("JDBC.autoCommit", "false");

        Injector injector = Guice.createInjector(
                JdbcHelper.HSQLDB_Embedded,
                new Module() {
                    public void configure(Binder binder) {
                        Names.bindProperties(binder, myBatisProperties);
                    }
                }
        );
    }

}
