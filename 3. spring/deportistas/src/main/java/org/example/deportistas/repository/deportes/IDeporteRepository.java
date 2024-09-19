package org.example.deportistas.repository.deportes;

import org.example.deportistas.entity.Deporte;

import java.util.List;

public interface IDeporteRepository {

    List<Deporte> getAll();
}
