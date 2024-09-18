package org.mercadolibre.edad.controller;

import org.mercadolibre.edad.component.DateValidator;
import org.mercadolibre.edad.service.IAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {
    @Autowired
    IAgeService ageService;
    @Autowired
    DateValidator dateValidator;

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<String> getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        String errorMessage = dateValidator.validate(day, month, year);

        if (!errorMessage.isBlank()){
            return ResponseEntity.badRequest().body(errorMessage);
        }

        return ResponseEntity.ok(String.valueOf(ageService.getAge(day, month, year)));
    }
}
