package co.mercadolibre.seguros_autos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha_siniestro")
    private LocalDate fechaSiniestro;
    @Column(name = "perdida_economica")
    private Double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id",nullable = false)
    @JsonBackReference
    @JsonIgnore

    private Vehiculo vehiculo;
}