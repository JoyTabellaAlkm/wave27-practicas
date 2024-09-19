package com.mercadolibre.practicadeportista.service.impl;

import com.mercadolibre.practicadeportista.model.Deporte;
import com.mercadolibre.practicadeportista.model.DeportistaDTO;
import com.mercadolibre.practicadeportista.repository.DeportistasRepository;
import com.mercadolibre.practicadeportista.service.IDeportista;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Deportista implements IDeportista {
    DeportistasRepository deportistasRepository = new DeportistasRepository();
    @Override
    public List<Deporte> obtenerLista() {
        return deportistasRepository.getDeportes();
    }

    @Override
    public Deporte getDeporte(String nombre) {
        return deportistasRepository.getDeporte(nombre);
    }

    @Override
    public List<DeportistaDTO> getDeportistas() {
        return deportistasRepository.getDeportistaDTO();
    }
}
