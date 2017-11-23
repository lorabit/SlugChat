package main.java.slugchat.mybatis.domain;

public class Story {
    private int storyId;
    private String content;
    private String entityName;

    public String getContent() {
        return content;
    }

    public int getStoryId() {
        return storyId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }
}
