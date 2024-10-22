package com.mercadoLibre.HQL.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "actors")
@Data
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Double rating;
    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private Movies favoriteMovie;
    @OneToMany(mappedBy = "actor")
    @Column(name = "actor_movies")
    private List<ActorMovie> actorMovies;
    @OneToMany(mappedBy = "actor")
    @Column(name = "actor_episodes")
    private List<ActorEpisode> actorEpisodes;
}
