package ar.com.mercadolibre.dto.service.impl;

import ar.com.mercadolibre.dto.model.StarWarsCharacter;
import ar.com.mercadolibre.dto.model.dto.response.StarWarsDTO;
import ar.com.mercadolibre.dto.repository.StarWarsRepository;
import ar.com.mercadolibre.dto.service.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsService implements IStarWarsService {

    @Autowired
    StarWarsRepository starWarsRepository;

    @Override
    public List<StarWarsDTO> getCharacterByName(String name) {
        return starWarsRepository.getCharacters().stream()
                .filter(character -> character.getName().contains(name))
                .map(character -> new StarWarsDTO(character.getName(), character.getHeight(), character.getMass(),
                        character.getGender(), character.getHomeworld(), character.getSpecies()))
                .toList();
    }

    public List<StarWarsDTO> getAllCharacters(){
        return starWarsRepository.getCharacters().stream()
                .map(character -> new StarWarsDTO(character.getName(), character.getHeight(), character.getMass(),
                        character.getGender(), character.getHomeworld(), character.getSpecies()))
                .toList();
    }
}
