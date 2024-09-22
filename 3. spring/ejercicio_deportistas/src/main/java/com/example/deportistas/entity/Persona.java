package com.example.deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Entity
@Data
@AllArgsConstructor
public class Persona {
    private long id;
    private String nombre;
    private String apellido;
    private int edad;
    private long idDeporte;
}
