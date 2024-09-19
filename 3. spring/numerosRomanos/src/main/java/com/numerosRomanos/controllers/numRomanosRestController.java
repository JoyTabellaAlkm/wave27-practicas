package com.numerosRomanos.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class numRomanosRestController {

    @GetMapping("/{num}")
    public String translateRoman(@PathVariable int num) {
        List<Integer> numeros = Arrays.asList(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000);
        List<String> letras = Arrays.asList("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M");
        String res = "Numero no encontrado";

        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) == num) {
                res = letras.get(i);
            }
        }

        return res;
    }
}
