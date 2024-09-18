package com.ejercicios.numerosromanos.controller;

import com.ejercicios.numerosromanos.service.NumerosRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {
@Autowired
    NumerosRomanosService numerosRomanosService;

@GetMapping
    public String NumerosDecimalesARomanos(@RequestParam int numero){
       return numerosRomanosService.transformarNumeros(numero);
    }
}
