package com.ejercicios.edadpersona.controller;


import com.ejercicios.edadpersona.service.IObtenerEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadPersonaController {
    @Autowired
    IObtenerEdadService obtenerEdadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<?> getEdadDeUnaPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        return ResponseEntity.ok(obtenerEdadService.obtenerEdad(dia, mes, anio));
    }
}
