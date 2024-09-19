package com.mercadolibre.ejercicioCovid.service;

import com.mercadolibre.ejercicioCovid.model.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    List<PersonDTO> findAllRiskPersons();
}
