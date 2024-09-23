package co.mercadolibre.morse.controller;

import co.mercadolibre.morse.controller.service.impL.IMorse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controlador {

    @Autowired
    IMorse imorse;

    @GetMapping("/morse/{texto}")
    public String getTraduccion(@PathVariable String texto){
        return imorse.traduccion(texto);
    }

}
