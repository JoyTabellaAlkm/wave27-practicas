package com.mercadolibre.calculadoredad.controllers;
import com.mercadolibre.calculadoredad.services.ICalcularEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class CalcularEdadController {

    @Autowired
    ICalcularEdad calcularEdadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable String dia,@PathVariable String mes,@PathVariable String anio){
        return calcularEdadService.calcularEdad(dia,mes,anio);
    }

}
