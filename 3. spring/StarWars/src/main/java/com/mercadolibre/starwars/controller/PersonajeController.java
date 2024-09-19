package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.PersonajeDTO;
import com.mercadolibre.starwars.service.IPersonajeService;
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
    IPersonajeService personajeService;

    @GetMapping("/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        List<PersonajeDTO> response = personajeService.getByName(name);
        if(response.isEmpty()){
            return ResponseEntity.status(404).body("No hay personajes que contengan: " + name);
        }
        return ResponseEntity.ok(response);
    }
}
