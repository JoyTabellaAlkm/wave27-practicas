package com.meli.movies.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Double rating;
    @Column(name = "season_id")
    private Integer seasonId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "episode_id")
    private List<ActorEpisode> episodeActors;
}
