package com.bootcamp.joyeria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jewelry")
@NoArgsConstructor
@Setter @Getter
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    private String nombre;
    private String material;
    private Double pesoEnGramos;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;
}
