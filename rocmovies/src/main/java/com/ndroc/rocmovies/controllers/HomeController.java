package com.ndroc.rocmovies.controllers;

import java.util.Arrays;
import java.util.List;

import com.ndroc.rocmovies.interfaces.MovieRepository;
import com.ndroc.rocmovies.interfaces.MovieStyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ndroc.rocmovies.entities.Movie;
import com.ndroc.rocmovies.enums.MovieStyles;


@Controller
public class HomeController {

    @Value("${spring.profiles.active}")
    private String profile;

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieStyleRepository movieStyleRepository;


    @RequestMapping(value={"", "/", "home"})
    public String displayHomePage(Model model) {

        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("styles", movieStyleRepository.findAll());

        return "index";
    }
  
}
