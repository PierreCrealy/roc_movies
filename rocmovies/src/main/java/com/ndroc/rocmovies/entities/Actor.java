package com.ndroc.rocmovies.entities;


import jakarta.persistence.*;

@Entity
@Table(name="actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Actor() {}


    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

}
