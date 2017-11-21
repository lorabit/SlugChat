package main.java.slugchat.mybatis.domain;

public class Log {

    private Long logId;
    private Long profileId;
    private int logType;
    private Long createTime;
    private String content;

    public Log(){}

    public Log(com.kidschat.service.mobile.Log log){
        logId = log.getLogId();
        profileId = log.getProfileId();
        logType = log.getLogType().getNumber();
        createTime = log.getCreateTime();
        content = log.getContent();
    }

    public com.kidschat.service.mobile.Log toProto(){
        return com.kidschat.service.mobile.Log.newBuilder()
                .setContent(content)
                .setCreateTime(createTime)
                .setLogId(logId)
                .setLogType(com.kidschat.service.mobile.Log.LogType.forNumber(logType))
                .setProfileId(profileId)
                .build();
    }

    public int getLogType() {
        return logType;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public Long getLogId() {
        return logId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public void setLogType(int logType) {
        this.logType = logType;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
