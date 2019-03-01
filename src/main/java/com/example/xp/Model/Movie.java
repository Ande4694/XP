package com.example.xp.Model;


public class Movie {

    private int id;
    private String title;
    private String genre;
    private int duration;
    private String posterLink;

    public Movie(int id, String title, String genre, int duration, String posterLink) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.posterLink = posterLink;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPosterLink() {
        return posterLink;
    }

    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }
}