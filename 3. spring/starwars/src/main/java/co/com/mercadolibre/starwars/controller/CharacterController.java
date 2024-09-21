package co.com.mercadolibre.starwars.controller;

import co.com.mercadolibre.starwars.dto.response.CharacterDTO;
import co.com.mercadolibre.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
@Autowired
    ICharacterService characterService;

    @GetMapping("/characters/{name}")
    public ResponseEntity<?> seeCharactersByName(@PathVariable String name){
        List<CharacterDTO> foundCharacters = characterService.seeCharactersByName(name);
        return  new ResponseEntity<>(foundCharacters, HttpStatus.OK);
    }
    @GetMapping("/characters")
    public ResponseEntity<?> seeAllCharacters(){
        List<CharacterDTO> characters = characterService.seeAllCharactersDTO();
        return  new ResponseEntity<>(characters, HttpStatus.OK);
    }
}
