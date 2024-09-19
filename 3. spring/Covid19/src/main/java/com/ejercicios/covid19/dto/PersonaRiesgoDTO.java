package com.ejercicios.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class PersonaRiesgoDTO {
    private String nombreCompletoPersona;
    private Integer edad;
    private Boolean sintomaDeRiesgo;

}
