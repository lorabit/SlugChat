package main.java.slugchat.mobile.service.implementation.producers;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.kidschat.service.mobile.ChatbotResponse;
import com.kidschat.service.mobile.UserRequest;
import main.java.slugchat.mobile.service.implementation.annotations.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class ChatbotResponseProducerModule extends AbstractModule {

    static final ImmutableList<String> START_RESPONSES = ImmutableList.of(
            "小朋友，好久不见。\n 你可以跟我说：我要听故事。",
            "你好啊，小朋友。\n 你有什么问题要问我吗？",
            "小虫虫来啦。你想听小虫虫讲什么样的故事呢?"
    );

    static final ImmutableList<String> NOSPEECH_RESPONSES = ImmutableList.of(
            "今天有什么有趣的事情吗？",
            "小朋友，小虫虫可会讲故事了。",
            "你不跟小虫虫说话，小虫虫很无聊。",
            "你可以问小虫虫中国有多大。"
    );

    @Override
    protected void configure() {
        install(new DialogflowResultProducerModule());
        install(new GetBaiduResultProducerModule());
    }

    @Provides
    @CommandResponse
    String providesCommandResponse( @RequestSpeechText String text){
        if(text.startsWith("$")){
            Random rand = new Random();
            if(text.equals("$start")) {
                return START_RESPONSES.get(rand.nextInt(START_RESPONSES.size()));
            }
            if(text.equals("$noSpeech{30}")){
                return NOSPEECH_RESPONSES.get(rand.nextInt(NOSPEECH_RESPONSES.size()));
            }
        }
        return "";
    }

    @Provides
    @SelectedResult
    ListenableFuture<String> providesSelectedResult(
            @MobileExecutorService ListeningExecutorService service,
            @CommandResponse String commandResponse,
            @BaiduResult ListenableFuture<String> baiduResult,
            @DialogflowResult ListenableFuture<String> dialogflowResult
    ){
        if(commandResponse.length()>0){
            return Futures.immediateFuture(commandResponse);
        }
        ImmutableList<ListenableFuture<String>> futureResults = ImmutableList.of(baiduResult, dialogflowResult);
        ListenableFuture<List<String>> results = Futures.successfulAsList(futureResults);
        return service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                List<String> producedResults = results.get();
                String baidu = producedResults.get(0);
                String dialogflow = producedResults.get(1);
                if(baidu!=null && baidu.length()>0){
                    return baidu;
                }
                if(dialogflow!=null && dialogflow.length()>0){
                    return dialogflow;
                }
                return "我想先休息一下。";
            }
        });
    }

    @Provides
    ListenableFuture<ChatbotResponse> providesChatbotResponse(
            @MobileExecutorService ListeningExecutorService service,
            @SelectedResult ListenableFuture<String> result
    ){
        return service.submit(new Callable<ChatbotResponse>() {
            @Override
            public ChatbotResponse call() throws Exception {
                return ChatbotResponse.newBuilder().setText(result.get()).build();
            }
        });
    }

    @Provides
    @RequestProfileId
    Long providesProfileId(UserRequest request){
        return request.getProfileId();
    }


    @Provides
    @RequestSpeechText
    String providesSpeechText(UserRequest request){
        return request.getText();
    }
}
