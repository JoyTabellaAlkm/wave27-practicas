package com.example.deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

//@Entity
@AllArgsConstructor @Getter
public class Deporte {
    private long id;
    private String nombre;
    private Nivel nivel;
}
