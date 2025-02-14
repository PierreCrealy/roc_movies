package com.ndroc.rocmovies.entities;


import com.ndroc.rocmovies.enums.BorrowStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="borrows")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Enumerated(EnumType.STRING)
    private BorrowStatus status;

    public Borrow() {}


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BorrowStatus getStatus() {
        return status;
    }
    public void setStatus(BorrowStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", date=" + date +
                ", customer=" + customer +
                ", movie=" + movie +
                ", status=" + status +
                '}';
    }
}
