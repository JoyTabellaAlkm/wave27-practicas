package com.meli.showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrendaResponseDto {
    private Long codigo;
    private String nombre;
    private String tipo;
    private String marca;;
    private String color;
    private String talla;
    private int cantidad;
    @JsonProperty("precio_venta")
    private Double precioVenta;
}
