package com.meli.showroom.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrendaResponseDto {
    private String codigo;
    private String nombre;
    private String tipo;
    private String marca;;
    private String color;
    private String talla;
    private int cantidad;
    @JsonProperty("precio_venta")
    private Double precioVenta;
}
