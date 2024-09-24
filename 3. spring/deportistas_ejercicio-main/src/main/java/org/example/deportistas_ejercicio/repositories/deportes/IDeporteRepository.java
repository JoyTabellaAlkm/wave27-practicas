package org.example.deportistas_ejercicio.repositories.deportes;

import org.example.deportistas_ejercicio.entities.Deporte;

import java.util.List;

public interface IDeporteRepository {

    List<Deporte> getAll();
}
