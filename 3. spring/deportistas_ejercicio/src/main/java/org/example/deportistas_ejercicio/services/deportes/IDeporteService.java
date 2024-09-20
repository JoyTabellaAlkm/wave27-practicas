package org.example.deportistas_ejercicio.services.deportes;

import org.example.deportistas_ejercicio.entities.Deporte;

import java.util.List;
import java.util.Optional;

public interface IDeporteService {

    List<Deporte> findSports();

    Optional<Integer> getNivelByDeporte(String nombre);

}
