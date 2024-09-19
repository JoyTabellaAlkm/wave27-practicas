package com.ejercicios.deportes.controller;

import com.ejercicios.deportes.dto.PersonaDTO;
import com.ejercicios.deportes.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> verPersonasDeportistas() {
        List<PersonaDTO> listaPersonasDeportistas = iPersonaService.verPersonasDeportistas();
        if (listaPersonasDeportistas == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(listaPersonasDeportistas);
    }
}
