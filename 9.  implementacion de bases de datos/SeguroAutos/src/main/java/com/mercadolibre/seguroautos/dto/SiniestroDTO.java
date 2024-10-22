package com.mercadolibre.seguroautos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SiniestroDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fecha;

    @JsonProperty("perdida_economica")
    private Float perdidaEconomica;

    @JsonProperty("vehiculo_id")
    private Long vehicleId;

}
