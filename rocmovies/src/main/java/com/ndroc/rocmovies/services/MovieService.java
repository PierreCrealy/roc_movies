package com.ndroc.rocmovies.services;

import com.ndroc.rocmovies.entities.Borrow;
import com.ndroc.rocmovies.entities.Customer;
import com.ndroc.rocmovies.interfaces.BorrowRepository;
import com.ndroc.rocmovies.interfaces.MovieRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MovieService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Transactional
    public boolean transferedBorrowsToAnotherCustomer(Customer customerFrom, Customer customerTo)
    {
        Random random = new Random();
        List<Borrow> borrows = borrowRepository.findAllByCustomer(customerFrom);

        if(borrows.isEmpty())
        {
            throw new IllegalArgumentException("Le client d'origine n'a aucune location.");
        }

        if(Math.random() < 0.5)
        {
            throw new IllegalArgumentException("Pas de chance. 50/50 ");
        }

        borrows.forEach(borrow -> {
            borrow.setCustomer(customerTo);
            borrowRepository.save(borrow);
        });

        return true;
    }
}
