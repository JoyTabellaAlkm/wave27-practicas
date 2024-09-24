package org.example.deportistas_ejercicio.services.personas;

import org.example.deportistas_ejercicio.dto.SportsPersonsDTO;
import org.example.deportistas_ejercicio.entities.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    List<SportsPersonsDTO> findSportsPersons();
}
