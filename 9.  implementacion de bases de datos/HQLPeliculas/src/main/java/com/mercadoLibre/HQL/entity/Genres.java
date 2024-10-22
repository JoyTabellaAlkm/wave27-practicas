package com.mercadoLibre.HQL.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private String name;
    private Integer ranking;
    private Boolean active;
    @OneToMany(mappedBy = "genre")
    private List<Movies> movies;
    @OneToMany(mappedBy = "genre")
    private List<Movies> series;
}
