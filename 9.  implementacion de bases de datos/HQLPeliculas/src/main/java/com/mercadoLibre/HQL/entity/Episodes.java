package com.mercadoLibre.HQL.entity;

import com.mercadoLibre.HQL.service.actors.IActorsService;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "episodes")
@Data
public class Episodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private String title;
    private Integer number;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Double rating;
    @ManyToOne
    @JoinColumn(name = "seasons_id")
    private Seasons season;
    @OneToMany(mappedBy = "episode")
    private List<ActorEpisode> actors;
}
