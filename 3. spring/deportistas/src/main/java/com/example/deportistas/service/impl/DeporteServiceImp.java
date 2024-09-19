package com.example.deportistas.service.impl;

import com.example.deportistas.dto.DeporteDTO;
import com.example.deportistas.entity.Deporte;
import com.example.deportistas.repository.DeporteRepository;
import com.example.deportistas.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeporteServiceImp implements DeporteService {

    @Autowired
    private DeporteRepository repository = new DeporteRepository();

    @Override
    public DeporteDTO findByName(String name) {
        Deporte deporte = repository.findByName(name);

        return new DeporteDTO(deporte.getNombre(), deporte.getNivel());
    }

    @Override
    public List<DeporteDTO> findAll() {
        return repository.findAll().stream()
                .map(deporte -> new DeporteDTO(deporte.getNombre(), deporte.getNivel()))
                .collect(Collectors.toList());
    }

    @Override
    public Deporte findById(long id) {
        return repository.findById(id);
    }
}
