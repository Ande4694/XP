package com.example.xp.Repo;

import com.example.xp.Model.Movie;
import com.example.xp.Model.Poster;
import com.example.xp.Model.Showing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepo {

    List<Movie> getAllMovies ();

    List<Poster> GetLatestMovie();



    void updateMovie(Movie movie, int id);
    void deleteMovie(int id);
    void createMovie(Movie movie);
    int getMovieId(String movieName);
    void addBooking(String name, Boolean pay);


}
