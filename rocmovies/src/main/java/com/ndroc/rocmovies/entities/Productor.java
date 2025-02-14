package com.ndroc.rocmovies.entities;


import jakarta.persistence.*;

@Entity
@Table(name="productors")
public class Productor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Productor() {}


    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Productor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
