package com.mercadolibre.obrasliterarias.controller;

import com.mercadolibre.obrasliterarias.dto.request.ObraLiterariaRequestDTO;
import com.mercadolibre.obrasliterarias.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraLiterariaController {
    @Autowired
    IObraLiterariaService service;

    @PostMapping("/crear")
    public ResponseEntity<?> crearObraLiteraria(@RequestBody ObraLiterariaRequestDTO obraLiterariaRequestDTO) {
        return new ResponseEntity<>(service.crearObraLiteraria(obraLiterariaRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/autor/{autor}")
    public ResponseEntity<?> buscarPorAutor(@PathVariable String autor) {
        return new ResponseEntity<>(service.buscarPorAutor(autor), HttpStatus.OK);
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(service.buscarPorNombre(nombre), HttpStatus.OK);
    }
    @GetMapping("/top5")
    public ResponseEntity<?> buscarTop5PorPaginas() {
        return new ResponseEntity<>(service.buscarTop5PorPaginas(), HttpStatus.OK);
    }
    @GetMapping("/anio/{anio}")
    public ResponseEntity<?> buscarPorAnio(@PathVariable Integer anio) {
        return new ResponseEntity<>(service.buscarPorAnio(anio), HttpStatus.OK);
    }
    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> buscarPorEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(service.buscarPorEditorial(editorial), HttpStatus.OK);
    }
}
