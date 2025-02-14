package com.ndroc.rocmovies.entities;

import com.ndroc.rocmovies.enums.MovieStyles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String title;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MovieStyles style;

    @NotNull
    private Integer productionYear;

    @NotBlank
    @Pattern(regexp="^[A-Z]{2,3}-\\d{5,6}$")
    private String ref;

    @NotBlank
    private String imageSrc;

    @OneToOne
    @JoinColumn(name = "productor_id", referencedColumnName = "id")
    private Productor productor;

    public Movie() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieStyles getStyle() {
        return style;
    }

    public void setStyle(MovieStyles style) {
        this.style = style;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", style=" + style +
                ", productionYear=" + productionYear +
                ", ref='" + ref + '\'' +
                ", imageSrc='" + imageSrc + '\'' +
                '}';
    }
}
