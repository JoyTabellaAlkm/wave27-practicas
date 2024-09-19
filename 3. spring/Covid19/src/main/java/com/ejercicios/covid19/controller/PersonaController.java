package com.ejercicios.covid19.controller;

import com.ejercicios.covid19.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired
    IPersonaService iPersonaService;
    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> verPersonasConRiesgo(){
        if(iPersonaService.verPersonasConRiesgo() == null){
            return new ResponseEntity<>("Ninguna persona tiene sintomas de riesgo alto", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(iPersonaService.verPersonasConRiesgo());
    }
}
