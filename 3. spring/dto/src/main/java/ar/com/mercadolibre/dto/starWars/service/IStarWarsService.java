package ar.com.mercadolibre.dto.starWars.service;

import ar.com.mercadolibre.dto.starWars.model.StarWarsCharacter;

import java.util.List;

public interface IStarWarsService {

    List<StarWarsCharacter> getCharacterList();

    List<StarWarsCharacter> getCharacterByName(String name);
}
