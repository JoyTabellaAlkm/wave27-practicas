package ar.com.codigomorse.codigo.controller;

import ar.com.codigomorse.codigo.service.impl.CodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CodigoMorseController {

    @Autowired
    CodigoMorseService codigoMorseService;

    @GetMapping("/mensaje/{mensaje}")
    public String mensaje(@PathVariable String mensaje) {

        return codigoMorseService.decodificador(mensaje);
    }
}
