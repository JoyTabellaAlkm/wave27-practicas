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
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Double rating;
    @Column(name = "favorite_movie_id")
    private Integer favoriteMovieId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_id")
    private List<ActorEpisode> actorEpisodes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_id")
    private List<ActorMovie> actorMovies;
}
