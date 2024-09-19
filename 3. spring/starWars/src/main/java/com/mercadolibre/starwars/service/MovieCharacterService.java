package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.MovieCharacterDTO;

import java.util.List;

public interface MovieCharacterService {
    List<MovieCharacterDTO> findByName(String name);
}
