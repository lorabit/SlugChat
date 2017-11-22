package main.java.slugchat.api.producer;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.AbstractModule;
import main.java.slugchat.api.annotations.ApiExecutorService;

import java.util.concurrent.Executors;

public class ApiExecutorServiceProducerModule extends AbstractModule {

    private ListeningExecutorService service;

    @Override
    protected void configure() {
        service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        bind(ListeningExecutorService.class).annotatedWith(ApiExecutorService.class).toInstance(service);
    }


}
