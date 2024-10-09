package org.mercadolibre.morsecode.controller;

import org.mercadolibre.morsecode.service.IMorseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseCodeController {
    @Autowired
    IMorseCodeService iMorseCodeService;

    @GetMapping("/{codigo}")
    public String traduccion(@PathVariable String codigo){
        return iMorseCodeService.traduccion(codigo);
    }
}
