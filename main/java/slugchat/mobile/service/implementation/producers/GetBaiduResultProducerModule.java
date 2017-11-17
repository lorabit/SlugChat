package main.java.slugchat.mobile.service.implementation.producers;

import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.*;
import main.java.slugchat.mobile.service.implementation.annotations.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class GetBaiduResultProducerModule extends AbstractModule {


    @Inject
    ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));;


    @Override
    protected void configure() {
        bind(String.class).annotatedWith(HttpRequestUrl.class).toInstance("http://www.baidu.com/s");
        install(new GetHttpResponseProducerModule());
    }

    @Provides
    @BaiduResult
    ListenableFuture<String> providesBaiduResult(
            @HttpGetResponse ListenableFuture<String> httpResponseProvider){
        return service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return httpResponseProvider.get();
            }
        });
    }

    @Provides
    @HttpRequestParameters
    ImmutableMap<String,String> providesParameters(@RequestSpeechText String speech){
        return ImmutableMap.of("wd",speech);
    }


}
