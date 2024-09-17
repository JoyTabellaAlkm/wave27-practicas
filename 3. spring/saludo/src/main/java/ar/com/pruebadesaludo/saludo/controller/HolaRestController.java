package ar.com.pruebadesaludo.saludo.controller;

import ar.com.pruebadesaludo.saludo.service.ISaludo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HolaRestController {

    @Autowired
    ISaludo iSaludo;

    @GetMapping("/saludar/{name}")
    public String sayHello(@PathVariable String name) {
        return iSaludo.sayHello(name);
    }
}
