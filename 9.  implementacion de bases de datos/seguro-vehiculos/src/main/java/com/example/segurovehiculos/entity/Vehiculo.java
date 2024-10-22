package com.example.segurovehiculos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer cantidadRuedas;
    @OneToMany(mappedBy = "vehiculoDenunciado", cascade = CascadeType.ALL)
    List<Siniestro> siniestros;
}
