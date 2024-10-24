package com.meli.movies.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actor_movie")
public class ActorMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

}
