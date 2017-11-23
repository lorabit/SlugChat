package main.java.slugchat.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lorabit on 13/11/2017.
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class DialogflowWebhookRequest {
    private String timestamp;
    private String sessionId;
    private String id;
    private Result result;


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result{
        private String resolvedQuery;
        private Map<String, String> parameters;
        private Metadata metadata;

        public Metadata getMetadata() {
            return metadata;
        }

        public String getResolvedQuery() {
            return resolvedQuery;
        }

        public Map<String, String> getParameters() {
            return parameters;
        }

        public void setResolvedQuery(String resolvedQuery) {
            this.resolvedQuery = resolvedQuery;
        }

        public void setParameters(Map<String, String> parameters) {
            this.parameters = parameters;
        }

        public void setMetadata(Metadata metadata) {
            this.metadata = metadata;
        }


        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Metadata{
            private String intentId;
            private String intentName;

            public String getIntentId() {
                return intentId;
            }

            public String getIntentName() {
                return intentName;
            }

            public void setIntentId(String intentId) {
                this.intentId = intentId;
            }

            public void setIntentName(String intentName) {
                this.intentName = intentName;
            }
        }
    }

    public Result getResult() {
        return result;
    }

    public String getId() {
        return id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}