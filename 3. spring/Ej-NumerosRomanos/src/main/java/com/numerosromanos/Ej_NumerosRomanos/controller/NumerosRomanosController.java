package com.numerosromanos.Ej_NumerosRomanos.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.numerosromanos.Ej_NumerosRomanos.service.INumerosRomanos;

@RestController
public class NumerosRomanosController {

    @Autowired
    INumerosRomanos numerosRomanos;

    @GetMapping("/{numero}")
    public String numRomano(@PathVariable Integer numero){
        return numerosRomanos.numRomano(numero);
    }

}
