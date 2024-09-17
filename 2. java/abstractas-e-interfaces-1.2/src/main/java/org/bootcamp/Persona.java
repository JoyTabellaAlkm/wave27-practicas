package org.bootcamp;

import java.util.List;

public class Persona {
    private String nombreCompleto;
    private List<String> atributos;
    private List<String> habilidades;

    public Persona(String nombreCompleto, List<String> atributos, List<String> habilidades) {
        this.nombreCompleto = nombreCompleto;
        this.atributos = atributos;
        this.habilidades = habilidades;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public List<String> getAtributos() {
        return atributos;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }
}
