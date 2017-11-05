package main.java.slugchat.mobile.service.implementation;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class DialogflowModule extends AbstractModule {

    private AIConfiguration aiConfiguration;

    @Override
    protected void configure() {
        aiConfiguration = new AIConfiguration("360f730cc1034b19864a1cae700ff632");
    }


    @Provides
    @Singleton
    AIDataService providesAIDataService(){
        return new AIDataService(aiConfiguration);
    }


}
