package co.com.mercadolibre.starwars.service;

import co.com.mercadolibre.starwars.dto.response.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> seeCharactersByName(String name);
    List<CharacterDTO> seeAllCharactersDTO();

}
