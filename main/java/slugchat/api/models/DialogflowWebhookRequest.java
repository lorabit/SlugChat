package main.java.slugchat.api.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lorabit on 13/11/2017.
 */
public class DialogflowWebhookRequest {
    private String timestamp;
    private String sessionId;
    private String id;
    private OriginalRequest originalRequest;


    public OriginalRequest getOriginalRequest() {
        return originalRequest;
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

    public void setOriginalRequest(OriginalRequest originalRequest) {
        this.originalRequest = originalRequest;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public class OriginalRequest {


        private Data data;
        private String source;

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }


        public class Data {

            private Inputs inputs;

            public Inputs getInputs() {
                return inputs;
            }

            public void setInputs(Inputs inputs) {
                this.inputs = inputs;
            }


            public class Inputs extends ArrayList<Input> {
            }

            public class Input {
                private String intent;

                public String getIntent() {
                    return intent;
                }

                public void setIntent(String intent) {
                    this.intent = intent;


                }
            }


        }
        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

    }
}