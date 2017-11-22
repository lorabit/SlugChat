package main.java.slugchat.mybatis.mapper;

import main.java.slugchat.mybatis.domain.Poem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PoemMapper {
    @Select("SELECT * FROM tbl_poems WHERE poemId=#{poemId}")
    Poem getPoemById(@Param("poemId") int poemId);

    @Select("SELECT * FROM tbl_poems WHERE author=#{author}")
    List<Poem> listPoemsWithAuthor(@Param("author") String author);

    @Select("SELECT * FROM tbl_poems WHERE title=#{title}")
    List<Poem> listPoemsWithTitle(@Param("title") String title);

    @Select("SELECT * FROM tbl_poems WHERE title=#{title} and author=#{author}")
    List<Poem> listPoemsWithTitleAndAuthor(Poem poem);
}
