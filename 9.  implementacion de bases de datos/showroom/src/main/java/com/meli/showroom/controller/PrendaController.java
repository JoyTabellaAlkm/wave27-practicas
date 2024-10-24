package com.meli.showroom.controller;

import com.meli.showroom.dto.PrendaRequestDto;
import com.meli.showroom.service.IPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {
    @Autowired
    IPrendaService prendaService;

    @PostMapping
    public ResponseEntity<?> nuevaPrenda(@RequestBody PrendaRequestDto prenda){
        return new ResponseEntity<>(prendaService.nuevaPrenda(prenda), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listarPrendas(@RequestParam(required = false) String name){
        return new ResponseEntity<>(prendaService.listarPrendas(name), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> devolverPrenda(@PathVariable Long code){
        return new ResponseEntity<>(prendaService.devolverPrenda(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> actualizarPrenda(@PathVariable Long code, @RequestBody PrendaRequestDto prenda){
        return new ResponseEntity<>(prendaService.actualizarPrenda(code, prenda), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> eliminarPrenda(@PathVariable Long code){
        return new ResponseEntity<>(prendaService.eliminarPrenda(code), HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> listarPrendasPorTalla(@PathVariable String size){
        return new ResponseEntity<>(prendaService.listarPrendasPorTalla(size), HttpStatus.OK);
    }
}
