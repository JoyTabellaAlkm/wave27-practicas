package com.SpringP2.codigoMorse.controller;

import com.SpringP2.codigoMorse.service.ICodigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codigo")
public class CodigoMorseController {

    @Autowired
    ICodigoService iCodigoService;

    @GetMapping("/{variable}")
    public String decodificarCodigo(@PathVariable String variable) {
        return iCodigoService.decodificador(variable);
    }
}
