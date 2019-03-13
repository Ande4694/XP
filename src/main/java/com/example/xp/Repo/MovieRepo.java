package com.example.xp.Repo;

import com.example.xp.Model.Movie;
import com.example.xp.Model.Poster;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepo {

    List<Movie> getAllMovies ();

    List<Poster> GetLatestMovie();


    void updateMovie(Movie movie, int id);
    void deleteMovie(int id);
    void createMovie(Movie movie);
    int getMovieId(String movieName);


}
