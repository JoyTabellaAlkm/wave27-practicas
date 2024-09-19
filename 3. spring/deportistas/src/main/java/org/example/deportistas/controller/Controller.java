package org.example.deportistas.controller;

import org.example.deportistas.dto.SportsPersonsDto;
import org.example.deportistas.entity.Deporte;
import org.example.deportistas.service.deportes.IDeporteService;
import org.example.deportistas.service.personas.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IDeporteService deporteService;

    @GetMapping("/findSports")
    public List<Deporte> findSports() {
        return deporteService.findSports();
    }

    @GetMapping("/findSports/{nombre}")
    public ResponseEntity<Integer> getNivelByDeporte(@PathVariable String nombre) {
        Optional<Integer> nivel = deporteService.getNivelByDeporte(nombre);

        if(nivel.isPresent()){
            return ResponseEntity.ok(nivel.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportsPersonsDto>> findSportsPersons() {
        return ResponseEntity.ok(personaService.findSportsPersons());
    }
}
