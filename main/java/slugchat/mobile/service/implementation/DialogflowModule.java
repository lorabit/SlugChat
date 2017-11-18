package main.java.slugchat.mobile.service.implementation;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class DialogflowModule extends AbstractModule {

    private AIConfiguration aiConfiguration;


    public DialogflowModule(String apiKey){
        aiConfiguration = new AIConfiguration(apiKey);
    }

    @Override
    protected void configure() {
        bind(AIDataService.class).toInstance(new AIDataService(aiConfiguration));
    }

}
