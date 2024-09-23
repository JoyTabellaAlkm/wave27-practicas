package co.mercadolibre.saludo.controller;

import co.mercadolibre.saludo.service.ISaludo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    ISaludo iSaludo;

    @GetMapping("/api/saludo/{nombre}/{apellido}")
    public String getSaludo(@PathVariable String nombre, @PathVariable String apellido){
        return iSaludo.saludar(nombre, apellido);
    }


}
