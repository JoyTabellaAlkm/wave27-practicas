package com.mercadolibre.productos.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoRequestDto {
    private String nombre;
    private String tipo;
    @JsonProperty("precio_venta")
    private Double precioVenta;
    @JsonProperty("precio_costo")
    private Double precioCosto;
    private Integer stock;
}
