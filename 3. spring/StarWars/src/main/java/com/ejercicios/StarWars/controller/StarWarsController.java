package com.ejercicios.StarWars.controller;

import com.ejercicios.StarWars.service.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarWarsController {

    @Autowired
    IStarWarsService starWarsService;

    @GetMapping("/characters")
    public ResponseEntity<?> getAllCharacter(){
        return ResponseEntity.ok(starWarsService.getAllCharacters());
    }
    @GetMapping("/characters/{name}")
    public ResponseEntity<?> getCharacterByName(@PathVariable String name){
        return ResponseEntity.ok(starWarsService.getAllCharactersByName(name));
    }
}
