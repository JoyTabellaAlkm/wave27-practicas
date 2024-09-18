package com.ejercicios.covid19.model;

import java.util.List;

public class Persona {
    private Long id;
            private String nombre;
    private String apellido;
    private Integer edad;
    private List<Sintoma> listaSintomas;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, Integer edad, List<Sintoma> listaSintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.listaSintomas = listaSintomas;
    }

    public List<Sintoma> getSintoma() {
        return listaSintomas;
    }

    public void setSintoma(List<Sintoma> sintoma) {
        this.listaSintomas = sintoma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
