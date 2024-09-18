package com.mercadolibre.calculadoraedad.controller;

import com.mercadolibre.calculadoraedad.service.ICalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class CalculadoraController {

    @Autowired
    ICalculadoraService IcalculadoraService;

    @GetMapping("{dia}/{mes}/{anio}")
    public String calcular(@PathVariable String dia, @PathVariable String mes, @PathVariable String anio) {
        return IcalculadoraService.calcular(dia, mes, anio);
    }

}
