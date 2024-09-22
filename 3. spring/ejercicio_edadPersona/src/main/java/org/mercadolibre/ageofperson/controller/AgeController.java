package org.mercadolibre.ageofperson.controller;

import org.mercadolibre.ageofperson.component.DateValidator;
import org.mercadolibre.ageofperson.service.IAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {
    @Autowired
    IAgeService iAgeService;
    @Autowired
    DateValidator dateValidator;

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<String> getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        String message = dateValidator.validate(day, month, year);
        if (!message.isBlank()){
            return ResponseEntity.badRequest().body(message);
        }
        return ResponseEntity.ok(String.valueOf(iAgeService.getAge(day, month, year)));
    }
}
