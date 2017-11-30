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

    public final static String UNSUPPORTED_RESPONSE = "当前客户端不支持该功能，请升级！";

    @Override
    protected void configure() {
        install(new DialogflowResultProducerModule());
        install(new GetBaiduResultProducerModule());
    }

    @Provides
    @SelectedResult
    ListenableFuture<String> providesSelectedResult(
            @MobileExecutorService ListeningExecutorService service,
            @BaiduResult ListenableFuture<String> baiduResult,
            @DialogflowResult ListenableFuture<String> dialogflowResult
    ){
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
            @SelectedResult ListenableFuture<String> result,
            UserRequest userRequest
    ){
        return service.submit(new Callable<ChatbotResponse>() {
            @Override
            public ChatbotResponse call() throws Exception {
                String text = result.get();
                ChatbotResponse.Builder builder = ChatbotResponse.newBuilder();
                if(text.startsWith("$")){
                    if(ClientVersionUtil.supportAudio(userRequest)) {
                        builder.setResponseType(ChatbotResponse.ResponseType.AUDIO);
                        builder.setText(text.substring(1));
                    }else{
                        builder.setText(UNSUPPORTED_RESPONSE);
                    }
                }else{
                    builder.setText(text);
                }
                return builder.build();
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
