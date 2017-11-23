package main.java.slugchat.mybatis.dao;

import com.google.common.collect.ImmutableList;
import main.java.slugchat.mybatis.domain.Story;

public interface StoryDao {

    ImmutableList<Story> listStoriesByEntityName(String entityName);

}
