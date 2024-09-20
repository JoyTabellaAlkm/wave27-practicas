package com.example.demo.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Persona {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    private UUID id;
    private String nombre;
    private String apellido;
    private int edad;

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void addSintoma(Sintoma sintoma) {
        this.sintomas.add(sintoma);
    }

    private List<Sintoma> sintomas;

    public Persona(String nombre, String apellido, int edad) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = new ArrayList<>();
    }
}
