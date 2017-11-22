package main.java.slugchat.mybatis.dao;

import com.google.common.collect.ImmutableList;
import main.java.slugchat.mybatis.domain.Poem;


public interface PoemDao {
    Poem getPoemById(int poemId);

    ImmutableList<Poem> listPoemsWithAuthor(String author);

    ImmutableList<Poem> listPoemsWithTitle(String title);

    ImmutableList<Poem> listPoemsWithTitleAndAuthor(String title, String author);
}
