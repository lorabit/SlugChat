package main.java.slugchat.mobile.service.domain;

import java.sql.Timestamp;

public class Client {

    private int id;
    private String device_token;
    private Double create_time;

    public void setId(int id){
        this.id = id;
    }

    public void setCreate_time(Double create_time) {
        this.create_time = create_time;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    public int getId() {
        return id;
    }

    public Double getCreate_time() {
        return create_time;
    }

    public String getDevice_token() {
        return device_token;
    }
}
