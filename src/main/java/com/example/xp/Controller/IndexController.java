package com.example.xp.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class IndexController {

    private final Logger log = Logger.getLogger(IndexController.class.getName());

    @GetMapping("/")
    public String index() {

        log.info("index called");


        return "index";

    }

    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }

    @GetMapping("/logoutSuccessful")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

}



