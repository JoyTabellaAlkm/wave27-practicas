package com.ejercicios.StarWars.service.impl;

import com.ejercicios.StarWars.dto.CharacterDTO;
import com.ejercicios.StarWars.entity.CharacterEntity;
import com.ejercicios.StarWars.repository.StarWarsRepository;
import com.ejercicios.StarWars.service.IStarWarsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsServiceImpl implements IStarWarsService {

    @Autowired
    StarWarsRepository repository;

    @Override
    public List<CharacterDTO> getAllCharacters() {
        List<CharacterEntity> characterEntities = repository.getCharacters();
        List<CharacterDTO> characterDTOS = new ArrayList<>();

        characterEntities.stream().forEach(characterEntity -> {
                    CharacterDTO dto = toDto(characterEntity);
                    characterDTOS.add(dto);
        }
        );
        return characterDTOS;
    }

    @Override
    public List<CharacterDTO> getAllCharactersByName(String name) {
        List<CharacterEntity> characterEntities = repository.getCharactersByName(name);
        List<CharacterDTO> characterDTOS = new ArrayList<>();
        characterEntities.stream().forEach(characterEntity -> {
                    CharacterDTO dto = toDto(characterEntity);
                    characterDTOS.add(dto);
                }
        );
        return characterDTOS;
    }

    private CharacterDTO toDto(CharacterEntity character){
        CharacterDTO dto = new CharacterDTO();
        dto.setName(character.getName());
        dto.setMass(character.getMass());
        dto.setSpecies(character.getSpecies());
        dto.setHeight(character.getHeight());
        dto.setGender(character.getGender());
        dto.setHomeworld(character.getHomeworld());
        return dto;
    }
}
