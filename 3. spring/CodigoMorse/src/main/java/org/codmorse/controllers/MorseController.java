package org.codmorse.controllers;

import org.codmorse.exceptions.CaracterInvalidoException;
import org.codmorse.services.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {
    @Autowired
    private MorseService morseService;

    @GetMapping("/morse/{morse}")
    public String morse(@PathVariable String morse) throws CaracterInvalidoException {
        return this.morseService.getMorseCode(morse);
    }

    @ExceptionHandler
    public String exceptionHandler(CaracterInvalidoException e) {
        return e.getMessage();
    }
}
