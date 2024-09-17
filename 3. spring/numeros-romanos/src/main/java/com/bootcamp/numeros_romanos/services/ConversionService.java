package com.bootcamp.numeros_romanos.services;

import com.bootcamp.numeros_romanos.exceptions.ValidationException;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ConversionService implements IConversionService {
    public Integer romanToArabic(String romanNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String arabicToRoman(Integer arabicNumber) {
        StringBuilder romanNumber = new StringBuilder();

        if (arabicNumber == null || arabicNumber <= 0 || arabicNumber > 3999) {
            throw new ValidationException("Number must be between 1 and 3999");
        }

        LinkedHashMap<Integer, String> arabicToRomanMap = getArabicToRomanMap();

        for (Map.Entry<Integer, String> entry : arabicToRomanMap.entrySet()) {
            while (arabicNumber >= entry.getKey()) {
                romanNumber.append(entry.getValue());
                arabicNumber -= entry.getKey();
            }
        }

        return romanNumber.toString();
    }

    private LinkedHashMap<Integer, String> getArabicToRomanMap() {
        LinkedHashMap<Integer, String> arabicToRomanMap = new LinkedHashMap<>();
        arabicToRomanMap.put(1000, "M");
        arabicToRomanMap.put(900, "CM");
        arabicToRomanMap.put(500, "D");
        arabicToRomanMap.put(400, "CD");
        arabicToRomanMap.put(100, "C");
        arabicToRomanMap.put(90, "XC");
        arabicToRomanMap.put(50, "L");
        arabicToRomanMap.put(40, "XL");
        arabicToRomanMap.put(10, "X");
        arabicToRomanMap.put(9, "IX");
        arabicToRomanMap.put(5, "V");
        arabicToRomanMap.put(4, "IV");
        arabicToRomanMap.put(1, "I");

        return arabicToRomanMap;
    }
}
