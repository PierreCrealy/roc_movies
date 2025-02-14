package com.ndroc.rocmovies.interfaces;

import com.ndroc.rocmovies.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
