package com.example.MiniSeries.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mini_series")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45, nullable = false)
    private String name;
    private Double rating;
    @Column(name = "amount_of_awards")
    private int amountOfAwards;
}
