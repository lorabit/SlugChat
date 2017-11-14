package main.java.slugchat.api.models;

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


        public class Data{
            private List<Input> inputs;

            public List<Input> getInputs() {
                return inputs;
            }

            public void setInputs(List<Input> inputs) {
                this.inputs = inputs;
            }

            public class Input{
//
//                private String intent;
//
//                public String getIntent() {
//                    return intent;
//                }
//
//                public void setIntent(String intent) {
//                    this.intent = intent;
//                }



                //                private List<RawInput> raw_inputs;
//
//
//                public class RawInput{
//                    private String query;
//
//                    public String getQuery() {
//                        return query;
//                    }
//
//                    public void setQuery(String query) {
//                        this.query = query;
//                    }
//                }
//
//                public List<RawInput> getRaw_inputs() {
//                    return raw_inputs;
//                }
//
//                public void setRaw_inputs(List<RawInput> raw_inputs) {
//                    this.raw_inputs = raw_inputs;
//                }
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
