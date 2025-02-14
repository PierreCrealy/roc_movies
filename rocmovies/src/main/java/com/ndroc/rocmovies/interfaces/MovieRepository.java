package com.ndroc.rocmovies.interfaces;

import com.ndroc.rocmovies.entities.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    //    @RestResource(path = "search-by-name" )
    //    Iterable<Option> findByNameContaining(@Param("val") String name);
    //
    //    @RestResource(path = "search-by-name-or-age")
    //    Iterable<Option> findByNameContainingOrPrice(@Param("n") String name, @Param("p") float price);

}
