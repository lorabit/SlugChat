package main.java.slugchat.api.producer;

import main.java.slugchat.mybatis.domain.Poem;
import main.java.slugchat.mybatis.domain.Story;

public final class ContentFormatUtil {
    private ContentFormatUtil(){}

    public static final String poemToSpeech(Poem poem){
        return poem.getTitle() + " " + poem.getDynasty() +
                " " + poem.getAuthor() + "\n" + poem.getContent();
    }

    public static final String storyToSpeech(Story story){
        return story.getContent();
    }
}
