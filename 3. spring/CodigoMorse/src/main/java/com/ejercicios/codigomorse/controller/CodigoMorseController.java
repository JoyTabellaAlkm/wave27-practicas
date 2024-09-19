package com.ejercicios.codigomorse.controller;

import com.ejercicios.codigomorse.service.IConversorMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversor")
public class CodigoMorseController {

    @Autowired
    IConversorMorseService conversorMorseService;

    @GetMapping("/{codigo}")
    public ResponseEntity<?> morseToSpanish(@PathVariable String codigo) {
        return ResponseEntity.ok(conversorMorseService.convertirMorse(codigo));
    }
}
