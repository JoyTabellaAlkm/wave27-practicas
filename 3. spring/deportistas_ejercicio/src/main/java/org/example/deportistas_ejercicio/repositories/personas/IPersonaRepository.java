package org.example.deportistas_ejercicio.repositories.personas;

import org.example.deportistas_ejercicio.entities.Persona;

import java.util.List;

public interface IPersonaRepository {
    List<Persona> getAll();
}
