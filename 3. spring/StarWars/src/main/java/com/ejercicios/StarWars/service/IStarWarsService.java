package com.ejercicios.StarWars.service;

import com.ejercicios.StarWars.dto.CharacterDTO;

import java.util.List;

public interface IStarWarsService {
    public List<CharacterDTO> getAllCharacters();
    public List<CharacterDTO> getAllCharactersByName(String name);
}
