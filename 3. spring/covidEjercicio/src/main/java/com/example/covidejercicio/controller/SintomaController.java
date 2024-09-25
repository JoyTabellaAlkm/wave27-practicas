package com.example.covidejercicio.controller;

import com.example.covidejercicio.modelo.Sintoma;
import com.example.covidejercicio.services.ISintomaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class SintomaController {

    @Autowired
    ISintomaServices sintomaServices;

    @GetMapping("/findSymptom")
    public List<Sintoma> mostrarSintomas() {
        return sintomaServices.obtenerSintomas();
    }

    @GetMapping("findSymptom/{nombre}")
    public ResponseEntity<?> consultarSintoma(@PathVariable String nombre) {
        return new ResponseEntity<>(sintomaServices.obtenerNivelGravedadSiExiste(nombre), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> encontrarPersona() {
        return new ResponseEntity<>(sintomaServices.encontrarPersona(), HttpStatus.OK);
    }
}

