package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDto;
import com.example.starwars.service.IPersonajeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {
    @Autowired
    IPersonajeServices personajeServices;

    @GetMapping("/obtener/{nombre}")
    public ResponseEntity<List<PersonajeDto>> PersonajeController(@PathVariable String nombre) {
        return ResponseEntity.ok(personajeServices.getPersonajes(nombre));
    }
}
