package com.ndroc.rocmovies.entities;


import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private String role;


    public Role() {}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }
    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", actor=" + actor +
                ", movie=" + movie +
                ", role='" + role + '\'' +
                '}';
    }
}
