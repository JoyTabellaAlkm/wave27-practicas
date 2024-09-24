package com.example.calcularedad.controller;

import com.example.calcularedad.service.IAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AgeController {


    private IAgeService ageService;

    @Autowired
    public AgeController(IAgeService ageService) {
        this.ageService = ageService;
    }

    @GetMapping("/{day}/{month}/{year}")
    public int findAge(@PathVariable int day,
                       @PathVariable int month,
                       @PathVariable int year) {

        return ageService.calculateAge(day, month, year);
    }

}
