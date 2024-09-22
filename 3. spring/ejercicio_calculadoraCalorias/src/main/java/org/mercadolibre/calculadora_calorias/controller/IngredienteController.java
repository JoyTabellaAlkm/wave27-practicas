package org.mercadolibre.calculadora_calorias.controller;

import org.mercadolibre.calculadora_calorias.dto.IngredienteDTO;
import org.mercadolibre.calculadora_calorias.service.impl.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    IngredienteService ingredienteService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {

        return new ResponseEntity<>(ingredienteService.getAll(), HttpStatus.OK);
    }

}
