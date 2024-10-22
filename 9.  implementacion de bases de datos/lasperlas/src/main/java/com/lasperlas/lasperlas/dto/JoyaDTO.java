package com.lasperlas.lasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoyaDTO {
    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;
}
