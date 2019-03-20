package com.example.xp.Controller;


import com.example.xp.Model.Movie;
import com.example.xp.Model.Order;
import com.example.xp.Model.Showing;
import com.example.xp.Repo.MovieRepo;
import com.example.xp.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.logging.Logger;

@Controller
public class IndexController {

    private final Logger log = Logger.getLogger(IndexController.class.getName());
    @Autowired
    UserRepo userRepo;
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    Showing show;

    @GetMapping("/")
    public String index(Model model) {

        log.info("index called");

        model.addAttribute("senesteFilm",movieRepo.GetLatestMovie());

       // for (int i = 0; i < 4 ; i++) {
         //   movieRepo.addBooking("Testy", false);
        //}


        return "index";

    }




    @GetMapping("/movie")
    public String movie(Model model) {

        log.info("movie called");

        model.addAttribute("alleVoresFilm",movieRepo.getAllMovies());

        Movie mov = movieRepo.getAllMovies().get(2);


        //VÆLG HVILKEN FILM
        // VÆLG HVORNÅR
        show = new Showing(mov, LocalDate.now());


        show.book("Jonathan", true, 4);

        return "movie";
    }

    @GetMapping("/Book")
    public String Book(Model model, Model modelBook) {

        log.info("Book called");

        model.addAttribute("titleFilm",movieRepo.getAllMovies());
        modelBook.addAttribute("booking", new Order());

        return "Book";
    }

    @PostMapping ("/Book")
    public String Book(@ModelAttribute Order order) {

        for (int i = 0; i < order.getSeats(); i++) {
            movieRepo.addBooking(order.getBuyerName(), order.isPay(), order.getMovieName());
        }


        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage() {


            return "login";
    }

    @GetMapping("/addMovie")
    public String userCreate(Model model) {

        log.info("userCreate call");

        model.addAttribute("movie", new Movie());

        return "addMovie";
    }

    @PostMapping("/userCreate")
    public String userCreate(@ModelAttribute Movie movie) {

        movieRepo.createMovie(movie);

        return "redirect:/addMovie";
    }


}





