package com.meli.miniseries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
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
