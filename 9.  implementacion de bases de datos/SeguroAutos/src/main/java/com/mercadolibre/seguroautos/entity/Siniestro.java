package com.mercadolibre.seguroautos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity(name = "siniestro")
@Data
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    @Column(name = "perdida_economica")
    private Float perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculoDenunciado;
}
