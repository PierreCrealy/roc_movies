package com.ndroc.rocmovies.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.ndroc.rocmovies.interfaces.MovieRepository;
import com.ndroc.rocmovies.services.MovieServiceManual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import com.ndroc.rocmovies.entities.Movie;
import com.ndroc.rocmovies.enums.MovieStyles;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("movie")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/manual")
    public String getListMoviesManual(Model model){

        MovieServiceManual movieRepositoryMano = new MovieServiceManual();
        model.addAttribute("moviesTitle", movieRepositoryMano.getAllMovies());

        return "movies/list-manual";
    }

    @GetMapping()
    public String getListMovies(@RequestParam(name = "style") Optional<MovieStyles> movieStyle, Model model) {

        List<MovieStyles> styles = Arrays.asList(MovieStyles.class.getEnumConstants());

//        if(movieStyle.isPresent()){
//
//        }

        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("styles", styles);

        return "movies/list";
    }
    
    
    @GetMapping("/{id}")
    @RequestMapping(value={"/{id}"})
    public String getMovieById(@PathVariable("id") Integer movieId, Model model){

        model.addAttribute("movie", movieRepository.findById(movieId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie " + movieId + "not found")));

        return "movies/show";
    }

    
    @GetMapping("/adding")
    public String addMovie(Model model) {

        List<MovieStyles> styles = Arrays.asList(MovieStyles.class.getEnumConstants());
        model.addAttribute("styles", styles);

        return "movies/add";
    }


    @PostMapping
    public String postAddMovie(@Valid Movie movie, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            System.out.println(movie);
            System.out.println(bindingResult);

            return "movies/add";
        }

        movieRepository.save(movie);

        return "redirect:/movie";

       //return this.getListMovies(java.util.Optional.empty(), model);
    }
    
    
    

}
