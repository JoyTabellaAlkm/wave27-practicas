package co.com.mercadolibre.starwars.service.impl;

import co.com.mercadolibre.starwars.dto.response.CharacterDTO;
import co.com.mercadolibre.starwars.entity.Character;
import co.com.mercadolibre.starwars.exception.CharactersNotFoundException;
import co.com.mercadolibre.starwars.repository.ICharacterRepository;
import co.com.mercadolibre.starwars.repository.impl.CharacterRepositoryImpl;
import co.com.mercadolibre.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService {
    @Autowired
    CharacterRepositoryImpl characterRepository;

    public List<CharacterDTO> seeCharactersByName(String name) {
      List<CharacterDTO> characterByNameList =  seeAllCharactersDTO().stream().filter(characterDTO -> characterDTO.getName().contains(name)).toList();

        if (characterByNameList.isEmpty()) {
            throw new CharactersNotFoundException("Ningún personaje coincide con el nombre : " + name);
        }
        return characterByNameList;
    }

    public List<CharacterDTO> seeAllCharactersDTO( ) {
        List<Character> characters = characterRepository.getCharacterList();
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        for(Character character : characters){
            characterDTOList.add(new CharacterDTO(character.getName(), character.getHeight(),
                    character.getMass(), character.getGender(), character.getHomeworld(),
                    character.getSpecies()));
        }
        if(characters.isEmpty()){
            throw new CharactersNotFoundException("Ningún personaje cargado.");
        }
       return characterDTOList;
    }
}
