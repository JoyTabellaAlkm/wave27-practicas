package com.mercadolibre.seguroautos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class VehiculoDTO {

    private String patente;

    private String marca;

    private String modelo;

    @JsonProperty("anio_fabricacion")
    private String anioFabricacion;

    @JsonProperty("cantidad_ruedas")
    private int cantidadRuedas;

    @JsonProperty("siniestros")
    private List<SiniestroDTO> siniestroDTO;

}
