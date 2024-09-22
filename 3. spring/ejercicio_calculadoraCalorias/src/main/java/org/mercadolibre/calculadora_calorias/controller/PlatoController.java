package org.mercadolibre.calculadora_calorias.controller;

import org.mercadolibre.calculadora_calorias.dto.PlatoRequestDTO;
import org.mercadolibre.calculadora_calorias.dto.PlatoResponseDTO;
import org.mercadolibre.calculadora_calorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plato")
public class PlatoController {

    @Autowired
    IPlatoService platoService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(platoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/byname")
    public ResponseEntity<?> getPlato(@RequestBody PlatoRequestDTO plato) {

        if (plato != null) {
            return new ResponseEntity<>(platoService.getByName(plato), HttpStatus.OK);
        }

        return new ResponseEntity<>("ERROR", HttpStatus.BAD_REQUEST);
    }
}
