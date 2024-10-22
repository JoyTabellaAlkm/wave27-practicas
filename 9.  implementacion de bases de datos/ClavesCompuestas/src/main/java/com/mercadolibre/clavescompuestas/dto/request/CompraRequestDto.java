package com.mercadolibre.clavescompuestas.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor @Getter @Setter
public class CompraRequestDto {
    @JsonProperty("cliente_id")
    private Long clienteId;

    private LocalDate fecha;

    private Double precio;
}
