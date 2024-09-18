package com.example.numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosController {
     @GetMapping("/{numero}")
    public String conversion(@PathVariable Integer numero) {
        StringBuilder total = new StringBuilder();
        int[] numeros = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};;
        String[] numerosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int i = 0 ; i < numeros.length ; i++){
            while(numero >= numeros[i]){
                total.append(numerosRomanos[i]);
                numero -= numeros[i];
            }
        }
        return total.toString();
    }
}
