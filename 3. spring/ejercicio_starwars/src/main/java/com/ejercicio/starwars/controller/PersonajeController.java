package com.ejercicio.starwars.controller;

import com.ejercicio.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

    @Autowired
    IPersonajeService personajeService;

    @GetMapping("/search_all")
    public ResponseEntity<?> listAll() throws IOException {
        return new ResponseEntity<>(personajeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/search_by_name/{name}")
    public ResponseEntity<?> listByName(@PathVariable String name) {
        try{
            if(!name.isBlank())
            {
                return new ResponseEntity<>(personajeService.listByName(name), HttpStatus.OK) ;
            }
        } catch (Exception e) {
            throw new RuntimeException("Hubo un error al querer mostrar la lista: " + e);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
