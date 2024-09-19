package ar.com.mercadolibre.dto.controller;

import ar.com.mercadolibre.dto.model.StarWarsCharacter;
import ar.com.mercadolibre.dto.model.dto.request.StarWarsRequestDTO;
import ar.com.mercadolibre.dto.model.dto.response.StarWarsDTO;
import ar.com.mercadolibre.dto.service.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/star-wars")
public class StarWarsController {

    @Autowired
    IStarWarsService starWarsService;

    @GetMapping("/{name}")
    public ResponseEntity<?> getCharacterByName(@PathVariable String name){

        List<StarWarsDTO> response = starWarsService.getCharacterByName(name);

        if (response.isEmpty()){
            return ResponseEntity.status(404).body("No hay personajes que contengan: " + name);
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/character")
    public ResponseEntity<?> getCharacters(){
        List<StarWarsDTO> response = starWarsService.getAllCharacters();

        if (response.isEmpty()){
            return ResponseEntity.status(404).body("No hay personajes cargados!");
        }

        return ResponseEntity.ok(response);

    }

    @GetMapping("/body")
    public ResponseEntity<?> getCharacterByName(@RequestBody StarWarsRequestDTO character){

        String res = "El personaje es " + character.getName() + " Su color de ojos es : " + character.getEyeColor();


        return ResponseEntity.ok(res);
    }

}
