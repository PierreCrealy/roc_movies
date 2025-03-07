package com.ndroc.rocmovies.controllers;

import com.ndroc.rocmovies.entities.Borrow;
import com.ndroc.rocmovies.entities.Customer;
import com.ndroc.rocmovies.entities.Movie;
import com.ndroc.rocmovies.entities.MovieStyle;
import com.ndroc.rocmovies.interfaces.*;
import com.ndroc.rocmovies.services.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Controller
@RequestMapping("borrow")
public class BorrowController {

    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MovieStyleRepository movieStyleRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;


    @GetMapping()
    public String getListBorrows(@RequestParam(name = "customer") Optional<Customer> customer, @RequestParam(name = "style") Optional<MovieStyle> style, Model model) {

        Iterable<Borrow> borrows = borrowRepository.findAll();

        if(customer.isPresent()){
            borrows = borrowRepository.findBorrowsByCustomer(customer.get());
        }

        if(style.isPresent()){
            Iterable<Movie> movies = movieRepository.findMoviesByStyle(style.get());

            if(movies.iterator().hasNext()){
                borrows = borrowRepository.findBorrowsByMovie(movies.iterator().next());
            }else{
                borrows = borrowRepository.findBorrowsByMovie(null);
            }
        }

        model.addAttribute("borrows", borrows);
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("styles", movieStyleRepository.findAll());

        return "borrows/list";
    }

    @GetMapping("/transferred-locations")
    public String transferredBorrows(Model model)
    {
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("message", "");

        return "borrows/transferred";
    }

    @GetMapping("/transferred")
    public String transferredBorrows(
            @RequestParam(name = "customerFrom") Customer customerFrom,
            @RequestParam(name = "customerTo") Customer customerTo,
            Model model
    )
    {
        var message = "";

        try{
            movieService.transferedMoviesToAnotherCustomer(customerFrom, customerTo);
            message = "Le transfert s'est bien passé.";
        }catch(Exception e){
            message = "Une erreur est survenue : " + e.getMessage();
        }

        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("message", message);

        return "borrows/transferred";
    }

}
