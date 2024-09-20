package com.mercadolibre.ejercicionumerosromanos.controllers;

import com.mercadolibre.ejercicionumerosromanos.services.impl.IConvertirNumero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class NumeroRomanoController {

    @Autowired
    IConvertirNumero iConvertirNumero;

    @GetMapping("convertir/{numero}")
    public String onvertirNumeroDecimalARomano(@PathVariable int numero) {
        return iConvertirNumero.convertirNumeroDecimalARomano(numero);
    }
}
