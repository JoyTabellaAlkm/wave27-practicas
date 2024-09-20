package com.ejercicios.CalculadoraCalorias.controller;

import com.ejercicios.CalculadoraCalorias.service.ICalcularCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularCaloriasController {

    @Autowired
    ICalcularCaloriasService service;

    @GetMapping("/{dishName}")
    public ResponseEntity<?> getDishInfoByName(@PathVariable String dishName){
        return ResponseEntity.ok(service.getDishInfoByName(dishName));
    }
}
