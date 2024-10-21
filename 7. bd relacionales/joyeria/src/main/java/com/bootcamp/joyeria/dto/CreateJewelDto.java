package com.bootcamp.joyeria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateJewelDto {
    String nombre;
    String material;
    @JsonProperty("peso")
    Double pesoEnGramos;
    String particularidad;
    @JsonProperty("posee_piedra")
    Boolean poseePiedra;
}
