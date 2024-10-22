package com.lasperlas.lasperlas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;
    private Boolean poseePiedra;
    private boolean ventaONo;

    public Joya(String nombre, String material, Integer peso, String particularidad, Boolean poseePiedra) {
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.poseePiedra = poseePiedra;
        this.ventaONo = true;
    }

    public Joya() {
        this.ventaONo = true;
    }
}
