package com.mercadolibre.seguroautos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patente;

    private String marca;

    private String modelo;

    @Column(name="anio_fabricacion")
    private String anioFabricacion;

    @Column(name = "cantidad_ruedas")
    private int cantidadRuedas;

    @OneToMany(mappedBy = "vehiculoDenunciado")
    private List<Siniestro> siniestros;

}
