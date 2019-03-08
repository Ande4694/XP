package com.example.xp.Controller;


import com.example.xp.Model.Movie;
import com.example.xp.Repo.MovieRepo;
import com.example.xp.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Controller
public class IndexController {

    private final Logger log = Logger.getLogger(IndexController.class.getName());
    @Autowired
    UserRepo userRepo;
    @Autowired
    MovieRepo movieRepo;

    @GetMapping("/")
    public String index() {

        log.info("index called");



        return "index";

    }


    @GetMapping("/movie")
    public String movie(Model model) {

        log.info("movie called");

        model.addAttribute("alleVoresFilm",movieRepo.getAllMovies());

        return "movie";
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





