package com.mercadoLibre.HQL.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "actor_movie")
@Data
public class ActorMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    @ManyToOne
    @JoinColumn(name = "actors_id")
    private Actors actor;
    @ManyToOne
    @JoinColumn(name = "movies_id")
    private Movies movie;
}
