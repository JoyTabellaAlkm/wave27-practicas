package com.mercadolibre.seguroautos.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "vehiculo")
@Data
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String patente;

    private String marca;

    private String modelo;

    @Column(name="anio_fabricacion")
    private String anioFabricacion;

    @Column(name = "cantidad_ruedas")
    private int cantidadRuedas;

    @OneToMany(mappedBy = "vehiculoDenunciado", cascade = CascadeType.ALL)
    private List<Siniestro> siniestros;

}
