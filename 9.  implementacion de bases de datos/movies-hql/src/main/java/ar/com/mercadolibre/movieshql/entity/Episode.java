package ar.com.mercadolibre.movieshql.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String createdAt;
    private String updatedAt;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Double rating;
    private Integer season_id;
}
