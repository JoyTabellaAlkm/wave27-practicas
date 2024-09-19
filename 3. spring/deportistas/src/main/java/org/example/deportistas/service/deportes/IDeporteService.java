package org.example.deportistas.service.deportes;

import org.example.deportistas.entity.Deporte;

import java.util.List;
import java.util.Optional;

public interface IDeporteService {

    List<Deporte> findSports();

    Optional<Integer> getNivelByDeporte(String nombre);

}
