package main.java.slugchat.mobile.service.domain;

public class Profile {

    private int profileId;
    private int clientId;
    private String name;
    private int avatar;
    private Long createTime;

    public String getName() {
        return name;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public int getProfileId() {
        return profileId;
    }

    public int getAvatar() {
        return avatar;
    }

    public int getClientId() {
        return clientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public Profile(com.kidschat.service.mobile.Profile proto){
        setClientId(proto.getClientId());
        setAvatar(proto.getAvatar());
        setCreateTime(proto.getCreateTime());
        setName(proto.getName());
        setProfileId(proto.getProfileId());
    }

    public com.kidschat.service.mobile.Profile toProto(){
        return com.kidschat.service.mobile.Profile.newBuilder()
                .setAvatar(getAvatar())
                .setClientId(getClientId())
                .setProfileId(getProfileId())
                .setName(getName())
                .setCreateTime(getCreateTime())
                .build();
    }
}
