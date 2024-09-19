package com.ejercicios.deportes.repository;

import com.ejercicios.deportes.dto.DeporteDTO;

import java.util.List;

public interface IDeporteRepository {
    List<DeporteDTO> verDeportes();
}
