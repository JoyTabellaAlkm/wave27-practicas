package org.example.starwars_ejercicio.repositories;

import org.example.starwars_ejercicio.entities.Personaje;

import java.util.List;

public interface IStarWarsRepository {
    List<Personaje> findByName(String name);
}
