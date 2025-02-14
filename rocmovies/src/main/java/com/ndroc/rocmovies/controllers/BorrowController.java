package com.ndroc.rocmovies.controllers;

import com.ndroc.rocmovies.entities.Borrow;
import com.ndroc.rocmovies.entities.Customer;
import com.ndroc.rocmovies.entities.Movie;
import com.ndroc.rocmovies.entities.MovieStyle;
import com.ndroc.rocmovies.interfaces.*;
import jakarta.validation.Valid;
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

    private final BorrowRepository borrowRepository;
    private final CustomerRepository customerRepository;
    private final MovieStyleRepository movieStyleRepository;
    private final MovieRepository movieRepository;

    public BorrowController(BorrowRepository borrowRepository, CustomerRepository customerRepository, MovieStyleRepository movieStyleRepository, MovieRepository movieRepository) {
        this.borrowRepository      = borrowRepository;
        this.customerRepository    = customerRepository;
        this.movieStyleRepository  = movieStyleRepository;
        this.movieRepository       = movieRepository;
    }

    @GetMapping()
    public String getListBorrows(@RequestParam(name = "customer") Optional<Customer> customer, @RequestParam(name = "style") Optional<MovieStyle> style, Model model) {

        Iterable<Borrow> borrows = borrowRepository.findAll();

        if(customer.isPresent()){
            borrows = borrowRepository.findBorrowsByCustomer(customer.get());
        }

        if(style.isPresent()){
            Iterable<Movie> movies = movieRepository.findMoviesByStyle(style.get());
            borrows = borrowRepository.findBorrowsByMovie(movies.iterator().next());
        }

        model.addAttribute("borrows", borrows);
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("styles", movieStyleRepository.findAll());

        return "borrows/list";
    }

}
