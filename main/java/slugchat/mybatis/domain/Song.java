package main.java.slugchat.mybatis.domain;

public class Song {
    private int songId;
    private String title;

    public String getTitle() {
        return title;
    }

    public int getSongId() {
        return songId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

}
