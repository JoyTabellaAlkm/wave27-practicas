package org.example.deportistas.repository.personas;

import org.example.deportistas.entity.Persona;

import java.util.List;

public interface IPersonaRepository {
    List<Persona> getAll();
}
