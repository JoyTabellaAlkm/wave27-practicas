package org.mercadolibre.practica1configurandojpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mini_serie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiniSerieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double rating;

    @Column(name = "amount_of_awards")
    private int amountAwards;
}
