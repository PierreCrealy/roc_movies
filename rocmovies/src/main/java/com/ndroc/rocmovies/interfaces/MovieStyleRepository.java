package com.ndroc.rocmovies.interfaces;

import com.ndroc.rocmovies.entities.MovieStyle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieStyleRepository extends CrudRepository<MovieStyle, Integer> {
}
