package com.meli.joyerialasperlas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "joyas")
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nro_id")
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private Boolean poseePiedra;
    @Column(name = "venta_o_no")
    private Boolean ventaONo;
}
