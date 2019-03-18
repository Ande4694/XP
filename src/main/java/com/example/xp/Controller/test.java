package com.example.xp.Controller;

import com.example.xp.Model.Movie;
import com.example.xp.Model.Showing;
import com.example.xp.Repo.MovieRepoImpl;

import java.time.LocalDate;

public class test {
    public static void main(String[] args) {

        MovieRepoImpl mr = new MovieRepoImpl();
      //Movie mov = mr.getAllMovies().get(0);
        Movie mov = new Movie("Thomas er en slyngel");


      Showing show = new Showing(mov, LocalDate.now());

      //show.book("Anders", true, 19);
      mr.addBooking("anders", true, LocalDate.now(), "thomas er en slyngel");

    }
}
