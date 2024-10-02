package com.meli.Clase15_StarWars.service;
import com.meli.Clase15_StarWars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterFinder {
    List<CharacterDTO> showAllCharacters();
    List<CharacterDTO> showCharactersByName(String name);
}
