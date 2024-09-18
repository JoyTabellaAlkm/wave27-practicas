package com.mercadolibre.deportista.service;

import com.mercadolibre.deportista.dto.DeportistaDTO;
import com.mercadolibre.deportista.model.Deporte;

import java.util.List;

public interface IDeportistaFinder {

    List<Deporte> getDeportes();

    String checkDeporte(String name);

    List<DeportistaDTO> getDeportistas();

}
