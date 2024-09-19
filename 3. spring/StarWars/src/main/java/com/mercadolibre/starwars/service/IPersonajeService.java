package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> getByName(String name);
}
