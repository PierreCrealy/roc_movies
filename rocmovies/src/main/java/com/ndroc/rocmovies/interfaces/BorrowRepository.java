package com.ndroc.rocmovies.interfaces;

import com.ndroc.rocmovies.entities.Borrow;
import com.ndroc.rocmovies.entities.Customer;
import com.ndroc.rocmovies.entities.Movie;
import com.ndroc.rocmovies.entities.MovieStyle;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
    Iterable<Borrow> findBorrowsByCustomer(Customer customer);

    Iterable<Borrow> findBorrowsByMovie(Movie movie);
}
