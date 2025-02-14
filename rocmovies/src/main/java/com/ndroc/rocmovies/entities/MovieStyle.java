package com.ndroc.rocmovies.entities;


import jakarta.persistence.*;

@Entity
@Table(name="movie_styles")
public class MovieStyle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String label;

    public MovieStyle() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "MovieStyle{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
