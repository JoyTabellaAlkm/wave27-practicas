package com.edad.Ej_Covid19.dto;

import com.edad.Ej_Covid19.modelo.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private int edad;
    List<Sintoma> sintomas = new ArrayList<>();

}
