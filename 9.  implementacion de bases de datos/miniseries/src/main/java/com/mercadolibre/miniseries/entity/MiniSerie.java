package com.mercadolibre.miniseries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MiniSerie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 45, nullable = false)
    String name;
    @Column(nullable = false)
    Double rating;
    @Column(name = "amount_of_awards")
    int amountOfAwards;


}
