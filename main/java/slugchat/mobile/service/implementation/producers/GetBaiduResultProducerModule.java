package main.java.slugchat.mobile.service.implementation.producers;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.*;
import main.java.slugchat.mobile.service.implementation.annotations.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class GetBaiduResultProducerModule extends AbstractModule {


    @BindingAnnotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface BaiduSingleResult{}


    @BindingAnnotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface BaiduListResult{}



    @Override
    protected void configure() {
        bind(String.class).annotatedWith(HttpRequestUrl.class).toInstance("http://www.baidu.com/s");
        install(new GetHttpResponseProducerModule());
    }

    @Provides
    @BaiduResult
    ListenableFuture<String> providesBaiduResult(
            @MobileExecutorService ListeningExecutorService service,
            @BaiduSingleResult ListenableFuture<String> singleResult,
            @BaiduListResult ListenableFuture<String> listResult){
        ImmutableList<ListenableFuture<String>> futureResults = ImmutableList.of(singleResult, listResult);
        ListenableFuture<List<String>> results = Futures.successfulAsList(futureResults);
        return service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                for(String result : results.get()){
                    if(result!=null && result.length()>0){
                        return result;
                    }
                }
                return "";
            }
        });
    }

    @Provides
    @HttpRequestParameters
    ImmutableMap<String,String> providesParameters(@RequestSpeechText String speech){
        return ImmutableMap.of("wd",speech);
    }

    @Provides
    @BaiduSingleResult
    ListenableFuture<String> provideBaiduSingleResult(
            @MobileExecutorService ListeningExecutorService service,
            @HttpGetResponse ListenableFuture<String> httpResponse){
        return service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Document doc = Jsoup.parse(httpResponse.get());
                Element resultNode = doc.selectFirst(".op_exactqa_s_answer");
                if(resultNode != null) {
                    return resultNode.text();
                }
                return "";
            }
        });
    }


    @Provides
    @BaiduListResult
    ListenableFuture<String> provideBaiduListResult(
            @MobileExecutorService ListeningExecutorService service,
            @HttpGetResponse ListenableFuture<String> httpResponse){
        return service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Document doc = Jsoup.parse(httpResponse.get());
                Elements resultNodes = doc.select(".op_exactqa_itemsArea .c-gap-top-small a");
                List<String> results = new LinkedList<String>();
                for(Element node : resultNodes){
                    if(node.hasAttr("title")) {
                        results.add(node.attr("title"));
                    }
                }
                if(results.isEmpty()) {
                    return "";
                }
                if(results.size() == 1){
                    return results.get(0);
                }
                StringBuilder resultBuilder = new StringBuilder();
                resultBuilder.append(results.get(0));
                for(int i = 1; i < results.size()-1; i++){
                    resultBuilder.append(",");
                    resultBuilder.append(results.get(i));
                }
                resultBuilder.append("和");
                resultBuilder.append(results.get(results.size() -1));
                return resultBuilder.toString();
            }
        });
    }




}
