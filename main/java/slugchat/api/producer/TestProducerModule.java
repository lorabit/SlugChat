package main.java.slugchat.api.producer;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import main.java.slugchat.api.annotations.TestAnnotation;

/**
 * Created by lorabit on 2017/10/3.
 */
public class TestProducerModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    @TestAnnotation
    public String getTestString(){
        return "abc";
    }
}
