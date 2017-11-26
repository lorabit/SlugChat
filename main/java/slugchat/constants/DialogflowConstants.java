package main.java.slugchat.constants;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public final class DialogflowConstants {
    public static final String PARAM_POEM_AUTHOR = "poem-author";
    public static final String PARAM_POEM_TITLE = "poem-title";
    public static final String PARAM_STORY_TITLE = "story-title";

    public static final String INTENT_POEM = "poem";
    public static final String INTENT_STORY_WITH_TITLE = "story - title";

    public static final ImmutableMap<String, String> EVENT_FROM_COMMAND = ImmutableMap.of(
            "$hit","hit",
            "$start","start",
            "$noSpeech{30}","no_speech"
    );

    private DialogflowConstants(){}
}
