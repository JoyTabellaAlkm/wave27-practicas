package com.edad.Ej_Covid19.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    List<Sintoma> sintomas = new ArrayList<>();

}
