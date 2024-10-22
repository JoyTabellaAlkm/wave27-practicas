package ar.com.mercadolibre.movieshql.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String createdAt;
    private String updatedAt;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private Integer genre_id;
}
