package org.example.starwars_ejercicio.services;

import org.example.starwars_ejercicio.dtos.PersonajeDTO;

import java.util.List;

public interface IStarWarsService {
    List<PersonajeDTO> findByName(String name);
}
