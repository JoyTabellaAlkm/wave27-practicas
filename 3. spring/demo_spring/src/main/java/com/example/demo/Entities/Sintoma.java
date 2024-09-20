package com.example.demo.Entities;

import java.util.UUID;

public class Sintoma {
    private UUID codigo;
    private String nombre;
    private Integer nivelGravedad;

    public Sintoma(String nombre, int nivelGravedad) {
        this.codigo = UUID.randomUUID();
        this.nombre = nombre;
        this.nivelGravedad = nivelGravedad;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelGravedad() {
        return nivelGravedad;
    }

    public void setNivelGravedad(int nivelGravedad) {
        this.nivelGravedad = nivelGravedad;
    }
}
