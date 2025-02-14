package com.ndroc.rocmovies.entities;


import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Role() {}


    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

}
