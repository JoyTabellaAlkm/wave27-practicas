package com.example.NumerosRomanos.service;

import org.springframework.stereotype.Service;

@Service
public class NumberService {
    public String convertToDecimal(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("El número debe estar entre 1 y 3999");
        }

        String[] miles = {"", "M", "MM", "MMM"};
        String[] cientos = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return miles[number / 1000] +
                cientos[(number % 1000) / 100] +
                decenas[(number % 100) / 10] +
                unidades[number % 10];
    }
}
