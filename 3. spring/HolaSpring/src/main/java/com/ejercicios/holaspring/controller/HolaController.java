package com.ejercicios.holaspring.controller;

import com.ejercicios.holaspring.service.HolaService;
import com.ejercicios.holaspring.service.IHolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HolaController {

@Autowired
private IHolaService iHolaService;

    @GetMapping("/{nombre}")
    public String sayHello(@PathVariable String nombre){
        return iHolaService.sayHello(nombre);
    }
}
