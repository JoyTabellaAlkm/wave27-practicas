package com.mercadolibre.ejercicioCovid.service;

import com.mercadolibre.ejercicioCovid.model.dto.SymptomDTO;

import java.util.List;

public interface SymptomService {
    List<SymptomDTO> findAll();

    SymptomDTO findByName(String name);
}
