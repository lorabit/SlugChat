package main.java.slugchat.mobile.service.implementation.producers;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.CharStreams;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Provides;
import main.java.slugchat.mobile.service.implementation.annotations.HttpGetResponse;
import main.java.slugchat.mobile.service.implementation.annotations.HttpRequestParameters;
import main.java.slugchat.mobile.service.implementation.annotations.HttpRequestUrl;
import main.java.slugchat.mobile.service.implementation.annotations.MobileExecutorService;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class GetHttpResponseProducerModule extends AbstractModule {


    @Override
    protected void configure() {
    }

    @Provides
    @HttpGetResponse
    ListenableFuture<String> getHttpResponse(
            @MobileExecutorService ListeningExecutorService service,
            @HttpRequestUrl String url,
            @HttpRequestParameters Provider<ImmutableMap<String, String>> params
    ){
        return service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                URLConnection connection = new URL(url+mapToQueryString(params.get())).openConnection();
//                URLConnection connection = new URL(url).openConnection();
                InputStream response = connection.getInputStream();
                String jsonString = CharStreams.toString(new InputStreamReader(response, Charsets.UTF_8));
                return jsonString;
            }
        });
    }

    private String mapToQueryString(ImmutableMap<String, String> map) {
        StringBuilder string = new StringBuilder();

        if(map.size() > 0) {
            string.append("?");
        }

        for(Map.Entry<String, String> entry : map.entrySet()) {
            string.append(entry.getKey());
            string.append("=");
            string.append(entry.getValue());
            string.append("&");
        }

        return string.toString();
    }

}
