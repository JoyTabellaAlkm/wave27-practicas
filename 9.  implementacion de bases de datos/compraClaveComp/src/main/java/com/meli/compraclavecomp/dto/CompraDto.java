package com.meli.compraclavecomp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDto {
    @JsonProperty("cliente_id")
    private Long clienteId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    private Double total;
    @JsonProperty("nombre_producto")
    private String nombreProducto;
    @JsonProperty("cantidad_producto")
    private int cantidadProducto;
}
