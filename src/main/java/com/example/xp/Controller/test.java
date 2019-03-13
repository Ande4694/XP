package com.example.xp.Controller;

import com.example.xp.Model.Movie;
import com.example.xp.Repo.MovieRepoImpl;

public class test {
    public static void main(String[] args) {

        MovieRepoImpl ho = new MovieRepoImpl();
       // Movie mov = ho.getAllMovies().get(2);


        //VÆLG HVILKEN FILM
        // VÆLG HVORNÅR
      //  Showing show = new Showing(mov, LocalDate.now());


        //show.book("Jonathan", true, 4);

        ho.createMovie(new Movie("hej", "comdey",134, "srs" ) );
    }
}
