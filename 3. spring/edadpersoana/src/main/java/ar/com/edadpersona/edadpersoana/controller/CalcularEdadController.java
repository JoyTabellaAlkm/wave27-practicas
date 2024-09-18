package ar.com.edadpersona.edadpersoana.controller;

import ar.com.edadpersona.edadpersoana.service.impl.CalcularEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcularedad")
public class CalcularEdadController {

    @Autowired
    private CalcularEdadService calcularEdadService;

    @GetMapping("/fecha/{dia}/{mes}/{anio}")
    public String calcularEdadSegunFecha(@PathVariable String dia,
                                      @PathVariable String mes,
                                      @PathVariable String anio) {

        return calcularEdadService.calcularEdad(dia,mes,anio);
    }

}
