package com.example.deportistas.controller;

import com.example.deportistas.dto.PersonaDTO;
import com.example.deportistas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/findSportsPersons/{name}")
    public ResponseEntity<?> findSportsPersons(@PathVariable String sportsName) {
        List<PersonaDTO> personas = personaService.findSportsPersons(sportsName);
        return ResponseEntity.ok(personas);
    }

}
