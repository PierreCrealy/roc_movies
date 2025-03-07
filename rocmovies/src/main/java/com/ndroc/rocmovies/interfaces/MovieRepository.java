package com.ndroc.rocmovies.interfaces;

import com.ndroc.rocmovies.entities.Movie;
import com.ndroc.rocmovies.entities.MovieStyle;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findMoviesByStyle(@NotNull MovieStyle style);

    //    @RestResource(path = "search-by-name" )
    //    Iterable<Option> findByNameContaining(@Param("val") String name);
    //
    //    @RestResource(path = "search-by-name-or-age")
    //    Iterable<Option> findByNameContainingOrPrice(@Param("n") String name, @Param("p") float price);

}
