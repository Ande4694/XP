package com.example.xp.Repo;

import com.example.xp.Model.Genre;
import com.example.xp.Model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepoImpl implements  MovieRepo{

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Movie> getAllMovies() {
        String sql = "SELECT Movies.idMovies, Movies.title, genre.movieGenre, Movies.duration, Movies.posterLink" +
                "        from XPgrp5000.Movies" +
                "        inner join genre" +
                "        on Movies.genre = genre.idgenre";
        return this.template.query(sql, new ResultSetExtractor<List<Movie>>() {
            @Override
            public List<Movie> extractData(ResultSet rs) throws SQLException, DataAccessException {

                int id;
                String title;
                String genre;
                int duration;
                String posterLink;

                ArrayList<Movie> allMovies = new ArrayList<>();

                while (rs.next()) {
                    id = rs.getInt("idMovies");
                    title = rs.getString("title");
                    genre = rs.getString("movieGenre");
                    duration = rs.getInt("duration");
                    posterLink = rs.getString("posterLink");


                    allMovies.add(new Movie(id, title, genre, duration, posterLink));
                }
                return allMovies;
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
        int genre = getGenreInt(movie.getGenre());

        this.template.update(sql, title, genre, duration, posterLink);

    }

    private int getGenreInt(String genre) {
        String sql = "select idgenre from "+
                "XPgrp5000.genre "+
                "where movieGenre =?";

        RowMapper<Genre> rm = new BeanPropertyRowMapper<>(Genre.class);

        List<Genre> searched = template.query(sql, rm, genre);

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

        this.template.update(sql, movie.getTitle(), getGenreInt(movie.getGenre()), movie.getDuration(), movie.getPosterLink());
    }
}
