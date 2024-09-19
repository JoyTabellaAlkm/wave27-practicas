package ar.com.mercadolibre.dto.starWars.service.impl;

import ar.com.mercadolibre.dto.starWars.model.StarWarsCharacter;
import ar.com.mercadolibre.dto.starWars.repository.StarWarsRepository;
import ar.com.mercadolibre.dto.starWars.service.IStarWarsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsServiceImpl implements IStarWarsService {

    StarWarsRepository starWarsRepository = new StarWarsRepository();

    public List<StarWarsCharacter> getCharacterList(){
        return starWarsRepository.getCharacters();
    }

    public List<StarWarsCharacter> getCharacterByName(String name){
        return starWarsRepository.getCharacters().stream()
                .filter(character -> character.getName().contains(name))
                .findAny()
                .stream().collect(Collectors.toList());
    }

}
