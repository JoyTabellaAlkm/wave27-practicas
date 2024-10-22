package com.mercadoLibre.HQLSeguroAutos.dto;

import lombok.Data;

@Data
public class VehiculoRequestDTO {
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer cantidadRuedas;
}
