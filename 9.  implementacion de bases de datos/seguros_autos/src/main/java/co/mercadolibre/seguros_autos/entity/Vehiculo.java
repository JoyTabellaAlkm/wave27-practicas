package co.mercadolibre.seguros_autos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 7, nullable = false, unique = true)
    private String patente;

    @Column(length = 30, nullable = false)
    private String marca;

    @Column(length = 30, nullable = false)
    private String modelo;

    @Column(name = "anio_fabricacion", length = 4)
    private Integer anioFabricacion;

    @Column(name = "cantidad_ruedas")
    private Integer cantidadRuedas;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Siniestro> siniestros;
}
