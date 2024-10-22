package com.mercadolibre.clavescompuestas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "compras")
@IdClass(CompraId.class)
@Getter @Setter
public class Compra {
    @Id
    @Column(name = "cliente_id")
   private Long clienteId;

    @Id
   private LocalDate fecha;

    private Double precio;



}
