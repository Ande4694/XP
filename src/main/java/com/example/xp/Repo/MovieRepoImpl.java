package com.example.xp.Repo;

import com.example.xp.Model.Genre;
import com.example.xp.Model.Movie;
import com.example.xp.Model.Poster;
import com.example.xp.Model.Showing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepoImpl implements  MovieRepo{

    @Autowired
    JdbcTemplate template;


    @Override
    public List<Movie> getAllMovies() {
        String sql = "SELECT *" +
                "        from XPgrp5000.Movies" ;
        return this.template.query(sql, new ResultSetExtractor<List<Movie>>() {
            @Override
            public List<Movie> extractData(ResultSet rs) throws SQLException, DataAccessException {

                int id;
                String title;
                int duration;
                String posterLink;

                ArrayList<Movie> allMovies = new ArrayList<>();

                while (rs.next()) {
                    id = rs.getInt("idMovies");
                    title = rs.getString("title");
                    duration = rs.getInt("duration");
                    posterLink = rs.getString("posterL,ink");


                    allMovies.add(new Movie(id ,title, duration, posterLink));
                }
                return allMovies;
            }
        });
    }




    @Override
    public List<Poster> GetLatestMovie() {
        String sql = "SELECT posterLink " +
                "        FROM XPgrp5000.Movies" +
                "        order by idMovies" +
                "        desc limit 4";
        return this.template.query(sql, new ResultSetExtractor<List<Poster>>() {
            @Override
            public List<Poster> extractData(ResultSet rs) throws SQLException, DataAccessException {

                String posterLink;

                ArrayList<Poster> LatestMovie = new ArrayList<>();

                while (rs.next()) {
                    posterLink = rs.getString("posterLink");


                    LatestMovie.add(new Poster(posterLink));
                }
                return LatestMovie;
            }
        });
    }


    @Override
    public void updateMovie(Movie movie, int id) {
        String sql = "update XPgrp5000.Movies "+
                "set title=?, genre=?, duration=?, posterLink=? "+
                "where idmovies="+ id;

        String title = movie.getTitle();
        int duration = movie.getDuration();
        String posterLink = movie.getPosterLink();


        this.template.update(sql, title, duration, posterLink);

    }

    @Override
    public void addBooking(String name, Boolean pay, LocalDate playTime, String movieName){
        String sql = "insert into booking Values (default, ?, ?, ?, ?); ";

        this.template.update(sql, name, pay, playTime, movieName);

    }


    @Override
    ////MÅSKE FEJL
    public int getMovieId(String movieName){
        String sql = "select idMovies from "+
                "XPgrp5000.Movies "+
                "where title =?";

        RowMapper<Movie> rm = new BeanPropertyRowMapper<>(Movie.class);

        List<Movie> searched = template.query(sql, rm, movieName);

        return searched.get(0).getId();
     }



    @Override
    public void deleteMovie(int id) {
        String sql = "delete from XPgrp5000.Movies where idMovies =?";

        this.template.update(sql, id);

    }

    @Override
    public void createMovie(Movie movie) {

        String sql = "insert into XPgrp5000.Movies values (default, ?, ?, ?, ?)";

        this.template.update(sql, movie.getTitle(),  movie.getDuration(), movie.getPosterLink());
    }
}
