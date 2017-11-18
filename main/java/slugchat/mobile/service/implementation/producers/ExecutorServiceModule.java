package main.java.slugchat.mobile.service.implementation.producers;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import main.java.slugchat.mobile.service.implementation.annotations.MobileExecutorService;

import java.util.concurrent.Executors;


//@Singleton
public class ExecutorServiceModule extends AbstractModule {

    private ListeningExecutorService service;

    @Override
    protected void configure() {
        service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        bind(ListeningExecutorService.class).annotatedWith(MobileExecutorService.class).toInstance(service);
    }
//
//    @Provides
//    @Singleton
//    @MobileExecutorService
//    ListeningExecutorService providesListeningExecutorService(){
//        return service;
//    }
}
