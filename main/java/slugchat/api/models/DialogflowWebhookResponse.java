package main.java.slugchat.api.models;

import java.util.List;
import java.util.Map;

/**
 * Created by lorabit on 13/11/2017.
 */
public class DialogflowWebhookResponse {
    private String speech;
    private String displayText;
    private Map<String, Object> data;
    private List<Map<String, String>> contextOut;
    private String source;
    private FollowupEvent followupEvent;

    public class FollowupEvent{
        private String name;
        private Map<String, String> data;

        public Map<String, String> getData() {
            return data;
        }

        public String getName() {
            return name;
        }

        public void setData(Map<String, String> data) {
            this.data = data;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public String getSource() {
        return source;
    }

    public FollowupEvent getFollowupEvent() {
        return followupEvent;
    }

    public List<Map<String, String>> getContextOut() {
        return contextOut;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setContextOut(List<Map<String, String>> contextOut) {
        this.contextOut = contextOut;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public void setFollowupEvent(FollowupEvent followupEvent) {
        this.followupEvent = followupEvent;
    }
}
