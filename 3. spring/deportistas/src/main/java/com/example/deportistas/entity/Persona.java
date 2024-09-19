package com.example.deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

//@Entity
@AllArgsConstructor @Getter
public class Persona {
    private long id;
    private String nombre;
    private String apellido;
    private int edad;
    private long idDeporte;
}
