package com.example.joyeria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Entity
//@Table
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private boolean poseePiedra;
    @Column(name = "venta_o_no")
    private boolean ventaONo;
}
