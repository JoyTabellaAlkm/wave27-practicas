package com.bootcamp.numeros_romanos.services;

public interface IConversionService {
    String arabicToRoman(Integer arabicNumber);
    Integer romanToArabic(String romanNumber);
}
