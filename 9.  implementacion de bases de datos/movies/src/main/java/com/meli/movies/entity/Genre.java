package com.meli.movies.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer ranking;
    private Double active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private List<Movie> movies;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private List<Serie> series;

}

