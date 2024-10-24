package com.meli.showroom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numero;
    private LocalDate fecha;
    private Double total;
    @Column(name = "medio_de_pago")
    private String medioDePago;

    @ManyToMany
    @JoinTable(
            name = "venta_prendas",
            joinColumns = @JoinColumn(name = "venta_numero"),
            inverseJoinColumns = @JoinColumn(name = "prenda_codigo")
    )
    private List<Prenda> listaDePrendas;
}
