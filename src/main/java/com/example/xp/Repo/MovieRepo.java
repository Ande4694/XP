package com.example.xp.Repo;

import com.example.xp.Model.Movie;

import java.util.List;

public interface MovieRepo {

    List<Movie> getAllMovies ();
    void updateMovie(Movie movie, int id);
    void deleteMovie(int id);
    void createMovie(Movie movie);

}
