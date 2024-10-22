package ar.com.mercadolibre.movieshql.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;
    private String favoriteMovie;
}
