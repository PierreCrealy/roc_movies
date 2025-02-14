package com.ndroc.rocmovies.interfaces;

import com.ndroc.rocmovies.entities.Productor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductorRepository extends JpaRepository<Productor, Integer> {
}
