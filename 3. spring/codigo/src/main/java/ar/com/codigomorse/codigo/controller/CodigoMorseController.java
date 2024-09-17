package ar.com.codigomorse.codigo.controller;

import ar.com.codigomorse.codigo.service.impl.CodificarCodigoMorse;
import ar.com.codigomorse.codigo.service.impl.DecodificarCodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CodigoMorseController {

    @Autowired
    DecodificarCodigoMorseService decodificarCodigoMorseService;

    @Autowired
    CodificarCodigoMorse codificarCodigoMorse;

    @GetMapping("/mensaje/oculto/{mensaje}")
    public String mensajeOculto(@PathVariable String mensaje) {
        return decodificarCodigoMorseService.decodificador(mensaje);
    }

    @GetMapping("/mensaje/aocultar/{mensaje}")
    public String mensajeAOcultar(@PathVariable String mensaje) {
        return codificarCodigoMorse.decodificador(mensaje);
    }
}
