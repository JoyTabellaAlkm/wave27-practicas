package org.mercadolibre.ejercicio2joyeria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jewerly")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Material material;
    private Double weight;
    private String peculiarity;
    @Column(name = "has_stone")
    private Boolean hasStone;
    @Column(name = "sale_or_not")
    private Boolean saleOrNot;

}
