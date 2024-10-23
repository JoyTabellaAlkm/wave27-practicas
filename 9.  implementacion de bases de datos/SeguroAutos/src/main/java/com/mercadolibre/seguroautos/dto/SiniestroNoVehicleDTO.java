package com.mercadolibre.seguroautos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class SiniestroNoVehicleDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fecha;

    @JsonProperty("perdida_economica")
    private Float perdidaEconomica;

}
