package com.example.demo.DTOs;

import com.example.demo.Entities.Persona;

import java.util.List;

public class FindRiskPersonsDTO {
    private List<Persona> personas;

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
