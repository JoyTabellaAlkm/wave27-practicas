package com.meli.compraclavecomp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compras")
@IdClass(value=CompraKey.class)
public class Compra {
    @Id
    @Column(name = "cliente_id")
    private Long clienteId;
    @Id
    private LocalDate fecha;

    private Double total;
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Column(name = "cantidad_producto")
    private int cantidadProducto;
}
