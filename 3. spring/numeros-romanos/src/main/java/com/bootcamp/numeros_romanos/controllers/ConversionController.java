package com.bootcamp.numeros_romanos.controllers;

import com.bootcamp.numeros_romanos.services.IConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversions")
public class ConversionController {

    final IConversionService conversionService;

    public ConversionController(IConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/fromRoman")
    public ResponseEntity<Integer> fromRomanToArabic(@RequestParam String romanNumber) {
        Integer arabicNumber = conversionService.romanToArabic(romanNumber);
        return ResponseEntity.ok(arabicNumber);
    }

    @GetMapping("/fromArabic")
    public ResponseEntity<String> fromRomanToArabic(@RequestParam Integer arabicNumber) {
        String romanNumber = conversionService.arabicToRoman(arabicNumber);
        return ResponseEntity.ok(romanNumber);
    }
}
