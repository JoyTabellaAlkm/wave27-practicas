package com.example.covidejercicio.dto;

import com.example.covidejercicio.modelo.Persona;
import com.example.covidejercicio.modelo.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaSintomaDto {
    private String nombre;
    private String apellido;

}
