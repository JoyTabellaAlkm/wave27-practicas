package com.mercadolibre.miniserieh2.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="mini_series")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double rating;
    @Column(name = "amount_of_awards")
    private Integer amountOfAwards;
}