package com.example.xp.Model;

public class Genre {
    private int id;
    private String movieGenre;

    public int getId() {
        return id;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public Genre(int id, String movieGenre) {
        this.id = id;
        this.movieGenre = movieGenre;
    }
}
