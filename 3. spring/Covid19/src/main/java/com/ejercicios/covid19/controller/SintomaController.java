package com.ejercicios.covid19.controller;

import com.ejercicios.covid19.service.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SintomaController {

    @Autowired
    ISintomaService iSintomaService;


@GetMapping("/findSymptoms")
    public ResponseEntity<?> verSintomas(){
    if(iSintomaService.verSintomas().isEmpty()){
        return ResponseEntity.badRequest().body("No hay sintomas registrados.");
    }
        return ResponseEntity.ok(iSintomaService.verSintomas());
    }
    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<?> consultarSintoma(@PathVariable String nombre)
    {
        if(iSintomaService.consultarSintoma(nombre) == null){
            return ResponseEntity.badRequest().body("Sintoma no encontrado.");
        }
        return ResponseEntity.ok("El nivel de gravedad de " + nombre + " es: " + iSintomaService.consultarSintoma(nombre));
    }


}
