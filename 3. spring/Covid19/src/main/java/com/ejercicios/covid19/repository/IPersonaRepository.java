package com.ejercicios.covid19.repository;

import com.ejercicios.covid19.model.Persona;

import java.util.List;

public interface IPersonaRepository {
    public List<Persona> verPersonas();
}
