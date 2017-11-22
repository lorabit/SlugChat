package main.java.slugchat.mybatis.domain;

public class Poem {
    private int poemId;
    private String title;
    private String author;
    private String dynasty;
    private String content;

    public String getContent() {
        return content;
    }

    public int getPoemId() {
        return poemId;
    }

    public String getAuthor() {
        return author;
    }

    public String getDynasty() {
        return dynasty;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public void setPoemId(int poemId) {
        this.poemId = poemId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
