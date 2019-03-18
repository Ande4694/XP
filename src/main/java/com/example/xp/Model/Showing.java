package com.example.xp.Model;

import com.example.xp.Repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class Showing {

    @Autowired
    MovieRepo movieRepo;

    private int id;
    private Movie movie;
    private Booking[] pladser = new Booking[50];
    private LocalDate playingDateTime;
    private int count = 0;

    public Showing() {
    }

    public Showing(Movie movie, LocalDate playing) {
        this.movie = movie;
        this.playingDateTime = playing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Booking[] getPladser() {
        return pladser;
    }

    public void setPladser(Booking[] pladser) {
        this.pladser = pladser;
    }

    public LocalDate getPlaying() {
        return playingDateTime;
    }

    public void setPlaying(LocalDate playing) {
        this.playingDateTime = playing;
    }

    public String book( String name, boolean pay, int people){

        String status = "";

        if (!LocalDate.now().isAfter(playingDateTime)){

            if(count+people>50){
                status = "error, not enough seats";

            }
            else {


                for (int i = 0; i < people; i++) {

                    pladser[count] = new Booking(pay, name);
                    status = "Booking made:\nname: "+name+"\npay: "+pay+"\nnumber of people: "+people+"\nPlaying date: " + playingDateTime+"\nMovie: "+movie.getTitle();
                    count++;

                }


            }

        }



        System.out.println(status);
        return status;
    }


    @Override
    public String toString() {
        return "Showing{" +
                "id=" + id +
                ", movie=" + movie +
                ", pladser=" + Arrays.toString(pladser) +
                ", playing date and time=" + playingDateTime +
                ", count=" + count +
                '}';
    }
}
