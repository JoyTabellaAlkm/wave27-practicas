package ar.com.mercadolibre.dto.starWars.controller;


import ar.com.mercadolibre.dto.starWars.model.StarWarsCharacter;
import ar.com.mercadolibre.dto.starWars.service.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/star-wars")
public class StarWarsController {


    @Autowired
    IStarWarsService starWarsService;

    @GetMapping("/character")
    public ResponseEntity<List<StarWarsCharacter>> getCharacterList(){

        List<StarWarsCharacter> response = starWarsService.getCharacterList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/character/{name}")
    public ResponseEntity<List<StarWarsCharacter>> getCharacterListByName(@PathVariable String name){

        List<StarWarsCharacter> response = starWarsService.getCharacterByName(name);

        if (response.isEmpty()){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.ok(response);
    }

}
