package com.example.deportistas.service;

import com.example.deportistas.dto.DeporteDTO;
import com.example.deportistas.entity.Deporte;

import java.util.List;

public interface DeporteService {
    Deporte findById(long id);
    DeporteDTO findByName(String name);

    List<DeporteDTO> findAll();
}
