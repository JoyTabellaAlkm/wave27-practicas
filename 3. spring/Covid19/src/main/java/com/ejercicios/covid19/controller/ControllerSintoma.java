package com.ejercicios.covid19.controller;

import com.ejercicios.covid19.model.Sintoma;
import com.ejercicios.covid19.service.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerSintoma {

    @Autowired
    ISintomaService iSintomaService;

@GetMapping("/findSymptoms")
    public ResponseEntity<List<Sintoma>> verSintomas(){
    if(iSintomaService.verSintomas() == null){
        return ResponseEntity.badRequest().body(iSintomaService.verSintomas());
    }
        return ResponseEntity.ok(iSintomaService.verSintomas());
    }
    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<String> consultarSintoma(@PathVariable String nombre)
    {
        if(iSintomaService.consultarSintoma(nombre) == null){
            return ResponseEntity.badRequest().body("Sintoma no encontrado");
        }
        return ResponseEntity.ok("El nivel de gravedad de " + nombre + " es: " + iSintomaService.consultarSintoma(nombre));
    }
}
