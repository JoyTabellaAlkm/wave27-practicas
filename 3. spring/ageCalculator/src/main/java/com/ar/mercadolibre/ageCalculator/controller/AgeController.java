package com.ar.mercadolibre.ageCalculator.controller;

import com.ar.mercadolibre.ageCalculator.exception.UnbornPersonException;
import com.ar.mercadolibre.ageCalculator.service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AgeController {
    private AgeService ageService;

    @Autowired
    public AgeController(AgeService ageService) {
        this.ageService = ageService;
    }

    @GetMapping("/{day}/{month}/{year}")
    public int findAge(@PathVariable int day,
        @PathVariable int month,
        @PathVariable int year) {

        return ageService.calculateAge(day, month, year);
    }
}
