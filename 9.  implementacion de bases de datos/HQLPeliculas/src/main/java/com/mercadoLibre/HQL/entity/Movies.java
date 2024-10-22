package com.mercadoLibre.HQL.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private String title;
    private Double rating;
    private Integer length;
    @ManyToOne
    @JoinColumn(name = "genres_id")
    private Genres genre;
    @OneToMany(mappedBy = "movie")
    @EqualsAndHashCode.Exclude @ToString.Exclude
    private List<ActorMovie> actors;
}
