package org.example.starwars_ejercicio.controllers;

import org.example.starwars_ejercicio.dtos.PersonajeDTO;
import org.example.starwars_ejercicio.services.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {
    @Autowired
    private IStarWarsService service;

    @GetMapping("personajes/{name}")
    public List<PersonajeDTO> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

}
