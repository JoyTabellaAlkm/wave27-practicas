package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.PrendaRequestDTO;
import com.mercadolibre.showroom.service.prenda.IPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/clothes")
public class PrendaController {

    @Autowired
    IPrendaService prendaService;

    @GetMapping()
    public ResponseEntity<?> obtenerTodasLasPrendas() {
        return new ResponseEntity<>(prendaService.obtenerPrendas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> agregarPrenda(@RequestBody PrendaRequestDTO prendaRequestDTO) {
        return new ResponseEntity<>(prendaService.agregarPrenda(prendaRequestDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPrenda(@PathVariable Long id) {
        return new ResponseEntity<>(prendaService.eliminarPrenda(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPrenda(@PathVariable Long id, @RequestBody PrendaRequestDTO prendaRequestDTO) {
        return new ResponseEntity<>(prendaService.actualizarPrenda(id, prendaRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> devolverUnaPrendaEnParticular (@PathVariable Long code) {
        return new ResponseEntity<>(prendaService.getPrendaByID(code),HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<?> devolverPrendasPorNombre (@RequestParam String nombre) {
        return new ResponseEntity<>(prendaService.obtenerPrendasPorNombre(nombre),HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> obtenerPrendasPorTalle (@PathVariable String size) {
        return new ResponseEntity<>(prendaService.obtenerPrendasPorTalle(size),HttpStatus.OK);
    }
}