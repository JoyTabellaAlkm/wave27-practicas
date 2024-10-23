package ar.com.mercadolibre.moviesConsultas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "actors")
@Data
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    private Double rating;

    @Column(name = "favorite_movie_id")
    private Integer favoriteMovieId;

    @ManyToMany(mappedBy = "actors")
    List<Movie> movies;
}
