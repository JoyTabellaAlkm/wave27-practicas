package ar.com.mercadolibre.moviesConsultas.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    private Integer id;

    private String title;

    private Double rating;
    private Integer awards;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Integer length;
    @Column(name = "genre_id")
    private Integer genreId;

    @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    List<Actor> actors;
}
