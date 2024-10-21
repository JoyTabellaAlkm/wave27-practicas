package com.bootcamp.joyeria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JewelDto {
    @JsonProperty("nro_identificatorio")
    Long id;
    String nombre;
    String material;
    @JsonProperty("peso")
    Double pesoEnGramos;
    String particularidad;
    @JsonProperty("posee_piedra")
    Boolean poseePiedra;
    @JsonProperty("venta_o_no")
    Boolean ventaONo;
}
