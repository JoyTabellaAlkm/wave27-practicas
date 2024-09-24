package com.mercadolibre.convertidorRomanos.controller;

import com.mercadolibre.convertidorRomanos.services.IConvertirRomanoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ConvertirRomanosController {
    @Autowired
    IConvertirRomanoServices iConvertirRomanoServices;

    @GetMapping("/buscar/{numeroDecimal}")
    public String obtenerValorNumeroRomano(@PathVariable int numeroDecimal){
        return iConvertirRomanoServices.obtenerRomano(numeroDecimal);
    }
}
