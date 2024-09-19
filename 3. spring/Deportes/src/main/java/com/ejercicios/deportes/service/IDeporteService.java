package com.ejercicios.deportes.service;

import com.ejercicios.deportes.dto.DeporteDTO;
import com.ejercicios.deportes.model.Deporte;

import java.util.List;

public interface IDeporteService {
    List<DeporteDTO> verDeportes();

    DeporteDTO verDeportesPorNombre(String nombre);
}
