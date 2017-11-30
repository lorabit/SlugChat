package main.java.slugchat.mybatis.dao;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import main.java.slugchat.mybatis.domain.Poem;
import org.apache.ibatis.session.SqlSession;


public class PoemDaoImpl implements PoemDao {
    @Inject
    private SqlSession sqlSession;


    @Override
    public Poem getPoemById(int poemId) {
        return (Poem) this.sqlSession.selectOne("PoemMapper.getPoemById",poemId);
    }

    @Override
    public ImmutableList<Poem> listPoemsWithAuthor(String author) {
        return ImmutableList.copyOf(
                sqlSession.selectList(
                        "PoemMapper.listPoemsWithAuthor",author));
    }

    @Override
    public ImmutableList<Poem> listPoemsWithTitle(String title) {
        return ImmutableList.copyOf(
                sqlSession.selectList(
                        "PoemMapper.listPoemsWithTitle",title));
    }

    @Override
    public ImmutableList<Poem> listPoemsWithTitleAndAuthor(String title, String author) {
        Poem poem = new Poem();
        poem.setAuthor(author);
        poem.setTitle(title);
        return ImmutableList.copyOf(
                sqlSession.selectList(
                        "PoemMapper.listPoemsWithTitleAndAuthor",poem));
    }
}
