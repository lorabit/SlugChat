package main.java.slugchat.mybatis.dao;

import main.java.slugchat.mybatis.domain.Story;

public interface StoryDao {

    Story getStoryByEntityName(String entityName);

}
