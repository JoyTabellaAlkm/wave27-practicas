package com.example.NumerosRomanos.controller;

import com.example.NumerosRomanos.service.NumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/numbers")

public class NumberController {

        private NumberService numberService;

        public NumberController(NumberService numberService) {
            this.numberService = numberService;
        }


        @GetMapping("/convert/{number}")
        public ResponseEntity<String> convertNumber(@PathVariable int number) {
            String romanNumber = numberService.convertToDecimal(number);
            String message = "El número ingresado fue " + number + " y en números romanos equivale a: " + romanNumber;
            return ResponseEntity.ok(message);
        }

    }

