package com.mercadolibre.clothes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clothing")
@Data
public class Clothing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "sale_code")
    @JsonIgnore
    private Sale sale;
}
