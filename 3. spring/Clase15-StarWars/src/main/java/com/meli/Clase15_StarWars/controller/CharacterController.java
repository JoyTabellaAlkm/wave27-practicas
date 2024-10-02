package com.meli.Clase15_StarWars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.meli.Clase15_StarWars.service.ICharacterFinder;

@RestController
@RequestMapping("/starwars")
public class CharacterController {
    @Autowired
    ICharacterFinder ICharacterFinder;

    @GetMapping("/characters")
    public ResponseEntity<?> showAllCharacters(){
        try {
            return new ResponseEntity<>(ICharacterFinder.showAllCharacters(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No hay personajes cargados", HttpStatus.OK);
        }
    }

    @GetMapping("/characters/{name}")
    public ResponseEntity<?> showCharactersByName(@PathVariable String name){
        try {
            return new ResponseEntity<>(ICharacterFinder.showCharactersByName(name), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No hay personajes que contengan " +name, HttpStatus.OK);
        }
    }
}
