package com.mercadoLibre.HQLSeguroAutos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "vehiculo")
@Data
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @Column(name = "anio_fabricacion")
    private Integer anioFabricacion;
    @Column(name = "cantidad_ruedas")
    private Integer cantidadRuedas;
    @Column(name = "siniestros_denunciados")
    @OneToMany(mappedBy = "vehiculo")
    private List<Siniestro> siniestrosDenunciados;
}
