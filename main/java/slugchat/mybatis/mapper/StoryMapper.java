package main.java.slugchat.mybatis.mapper;

import main.java.slugchat.mybatis.domain.Story;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StoryMapper {

    @Select("SELECT storyId,content,entityName FROM tbl_stories WHERE entityName = #{entityName}")
    List<Story> listStoriesByEntityName(@Param("entityName") String entityName);

}
