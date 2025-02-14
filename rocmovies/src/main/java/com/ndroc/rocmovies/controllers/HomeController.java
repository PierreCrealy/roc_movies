package com.ndroc.rocmovies.controllers;

import java.util.Arrays;
import java.util.List;

import com.ndroc.rocmovies.interfaces.MovieRepository;
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

    private final MovieRepository movieRepository;

    public HomeController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    @RequestMapping(value={"", "/", "home"})
    public String displayHomePage(Model model) {

        List<MovieStyles> styles = Arrays.asList(MovieStyles.class.getEnumConstants());

        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("styles", styles);

        return "index.html";
    }
  
}
