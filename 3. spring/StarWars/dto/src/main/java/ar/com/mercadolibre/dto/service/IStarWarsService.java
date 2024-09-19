package ar.com.mercadolibre.dto.service;

import ar.com.mercadolibre.dto.model.StarWarsCharacter;
import ar.com.mercadolibre.dto.model.dto.response.StarWarsDTO;

import java.util.List;

public interface IStarWarsService {

    List<StarWarsDTO> getCharacterByName(String name);

    List<StarWarsDTO> getAllCharacters();
}
