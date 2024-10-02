package com.meli.Clase14_Deportistas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeportistaDTO {
    private String nombre;
    private String apellido;
    @JsonProperty("nombre_deporte")
    private String nombreDeporte;
}
