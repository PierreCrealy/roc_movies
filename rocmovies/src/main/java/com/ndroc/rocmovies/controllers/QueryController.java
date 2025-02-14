package com.ndroc.rocmovies.controllers;


import com.ndroc.rocmovies.services.MovieServiceManual;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueryController {

    @Value("${app.welcomeMessage}")
    private String welcomeMessage;
    
    @GetMapping("/hello")
    public String sayHello(){
        
        return welcomeMessage;
    }

    @GetMapping("/manual")
    public List<String> getListMoviesManual(){

        MovieServiceManual movieRepositoryMano = new MovieServiceManual();
        return movieRepositoryMano.getAllMovies();
    }

}
