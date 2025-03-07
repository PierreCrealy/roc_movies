package com.ndroc.rocmovies.controllers;

import java.util.Optional;
import com.ndroc.rocmovies.entities.MovieStyle;
import com.ndroc.rocmovies.interfaces.MovieRepository;
import com.ndroc.rocmovies.interfaces.MovieStyleRepository;
import com.ndroc.rocmovies.interfaces.ProductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import com.ndroc.rocmovies.entities.Movie;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieStyleRepository movieStyleRepository;
    @Autowired
    private ProductorRepository productorRepository;


    @GetMapping()
    public String getListMovies(
            @RequestParam(name = "style") Optional<MovieStyle> movieStyle,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size,
            @RequestParam(name = "sort", defaultValue = "id") String sort,
            Model model
    )
    {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sort));
        Iterable<Movie> movies = movieRepository.findAll(pageable);

        if(movieStyle.isPresent()){
            movies = movieRepository.findMoviesByStyle(movieStyle.get());
        }

        model.addAttribute("movies", movies);
        model.addAttribute("styles", movieStyleRepository.findAll());

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

        model.addAttribute("styles", movieStyleRepository.findAll());
        model.addAttribute("productors", productorRepository.findAll());

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
    }
    
    
    

}
