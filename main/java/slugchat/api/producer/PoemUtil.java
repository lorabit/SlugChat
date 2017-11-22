package main.java.slugchat.api.producer;

import main.java.slugchat.mybatis.domain.Poem;

public final class PoemUtil {
    private PoemUtil(){}

    public static final String toSpeech(Poem poem){
        return poem.getTitle() + " " + poem.getDynasty() +
                " " + poem.getAuthor() + "\n" + poem.getContent();
    }
}
