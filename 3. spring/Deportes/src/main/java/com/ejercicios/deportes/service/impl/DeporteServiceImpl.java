package com.ejercicios.deportes.service.impl;

import com.ejercicios.deportes.dto.DeporteDTO;
import com.ejercicios.deportes.model.Deporte;
import com.ejercicios.deportes.repository.IDeporteRepository;
import com.ejercicios.deportes.service.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeporteServiceImpl implements IDeporteService {
    @Autowired
    IDeporteRepository iDeporteRepository;

    @Override
    public List<DeporteDTO> verDeportes() {
        return iDeporteRepository.verDeportes();
    }

    @Override
    public DeporteDTO verDeportesPorNombre(String nombre) {
        DeporteDTO deporteDTO = iDeporteRepository.verDeportes().stream().filter(deporte -> deporte.getNombre().equals(nombre)).findAny().orElse(null);
        return deporteDTO;
    }
}
