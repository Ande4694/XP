package com.example.xp.Model;


public class Movie {

    private int id;
    private String title;

    private int duration;
    private String posterLink;

    public Movie( String title, int duration, String posterLink) {
      //  this.id = id;
        this.title = title;

        this.duration = duration;
        this.posterLink = posterLink;
    }

    public Movie(int id, String title, int duration, String posterLink) {
          this.id = id;
        this.title = title;

        this.duration = duration;
        this.posterLink = posterLink;
    }

    public Movie() {
    }

    public Movie(String title) {
        this.title = title;
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
