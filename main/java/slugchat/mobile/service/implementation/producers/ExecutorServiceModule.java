package main.java.slugchat.mobile.service.implementation.producers;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;


@Singleton
public class ExecutorServiceModule extends AbstractModule {

    private ListeningExecutorService service;
    @Override
    protected void configure() {
        service = MoreExecutors.newDirectExecutorService();
    }

    @Provides
    @Singleton
    ListeningExecutorService providesListeningExecutorService(){
        return service;
    }
}
