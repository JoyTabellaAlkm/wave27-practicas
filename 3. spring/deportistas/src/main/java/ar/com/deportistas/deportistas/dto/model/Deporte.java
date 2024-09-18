package ar.com.deportistas.deportistas.dto.model;

import lombok.Data;

@Data
public class Deporte {
    private String nombre;
    private int nivel;

    public Deporte(int nivel, String nombre) {
        this.nivel = nivel;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
