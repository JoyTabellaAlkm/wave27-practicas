package ar.com.mercadolibre.joyas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "jewelry")
@Data
public class Jewelry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String material;

    private Integer weight;

    private String particularity;

    @Column(name = "has_stone")
    private Boolean hasStone;

    @Column(name = "sell_or_not")
    private Boolean sellOrNot = true;
}
