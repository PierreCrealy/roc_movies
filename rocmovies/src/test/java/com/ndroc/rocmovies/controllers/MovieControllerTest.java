package com.ndroc.rocmovies.controllers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ndroc.rocmovies.entities.Movie;


@ExtendWith(MockitoExtension.class)
public class MovieControllerTest {

    @Mock
    MovieService1 movieService;

    @InjectMocks
    MovieJsonController movieJsonController;


    @Test
    void testGetMovieById() {
       

        when(movieJsonController.getMovieById((long) 1));

        Movie result = movieJsonController.getMovieById((long) 1);

        assertTrue(result.getIdMovie() == 1 , "Ce résultat devrait être égal à 3");

    }


    @Test
    void testPostAddMovie() {

    }
}
