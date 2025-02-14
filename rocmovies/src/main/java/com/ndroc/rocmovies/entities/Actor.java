package com.ndroc.rocmovies.entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lastname;
    private String firstname;
    private Date birthdate;


    public Actor() {}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
