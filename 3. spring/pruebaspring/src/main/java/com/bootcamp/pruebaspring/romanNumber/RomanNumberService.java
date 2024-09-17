package com.bootcamp.pruebaspring.romanNumber;

import org.springframework.stereotype.Service;

@Service
public class RomanNumberService implements IRomanNumber{

    private final int[] decimalValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


    public String decimalToRoman(Integer number) {
        if (number < 1 || number > 3999) {
            return ("El número debe estar en el rango de 1 a 3999");
        }

        return buildRomanNumer(number);
    }

    public String buildRomanNumer(Integer number){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < decimalValues.length; i++) {
            while (number >= decimalValues[i]) {
                result.append(romanSymbols[i]);
                number -= decimalValues[i];
            }
        }
        return result.toString();
    }

}
