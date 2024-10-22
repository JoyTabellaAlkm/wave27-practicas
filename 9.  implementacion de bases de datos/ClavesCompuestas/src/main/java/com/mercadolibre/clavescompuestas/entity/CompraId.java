package com.mercadolibre.clavescompuestas.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.io.Serializable;
import java.time.LocalDate;
@Data
public class CompraId implements Serializable {

    private Long clienteId;
    private LocalDate fecha;
}
