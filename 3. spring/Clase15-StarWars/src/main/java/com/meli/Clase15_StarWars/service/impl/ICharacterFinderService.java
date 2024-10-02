package com.meli.Clase15_StarWars.service.impl;

import com.meli.Clase15_StarWars.dto.CharacterDTO;
import com.meli.Clase15_StarWars.repository.CharacterRepository;
import com.meli.Clase15_StarWars.service.ICharacterFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICharacterFinderService implements ICharacterFinder {
    @Autowired
    CharacterRepository CharacterRepository;


    @Override
    public List<CharacterDTO> showAllCharacters() {
        return CharacterRepository.getCharacters().stream()
                .map(character -> new CharacterDTO(character.getName(), character.getHeight(), character.getMass(),
                        character.getGender(), character.getHomeworld(), character.getSpecies()))
                .toList();
    }

    @Override
    public List<CharacterDTO> showCharactersByName(String name) {
        return CharacterRepository.getCharacters().stream()
                .filter(character -> character.getName().contains(name))
                .map(character -> new CharacterDTO(character.getName(), character.getHeight(), character.getMass(),
                        character.getGender(), character.getHomeworld(), character.getSpecies()))
                .toList();
    }
}
