package com.ejercicios.codigomorse.service.impl;

import com.ejercicios.codigomorse.service.IConversorMorseService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ConversorMorseImpl implements IConversorMorseService {
    @Override
    public String convertirMorse(String texto) {
        Map<String, String> morseMap = new HashMap<>();
        morseMap.put(".-", "A");
        morseMap.put("-...", "B");
        morseMap.put("-.-.", "C");
        morseMap.put("-..", "D");
        morseMap.put(".", "E");
        morseMap.put("..-.", "F");
        morseMap.put("--.", "G");
        morseMap.put("....", "H");
        morseMap.put("..", "I");
        morseMap.put(".---", "J");
        morseMap.put("-.-", "K");
        morseMap.put(".-..", "L");
        morseMap.put("--", "M");
        morseMap.put("-.", "N");
        morseMap.put("---", "O");
        morseMap.put(".--.", "P");
        morseMap.put("--.-", "Q");
        morseMap.put(".-.", "R");
        morseMap.put("...", "S");
        morseMap.put("-", "T");
        morseMap.put("..-", "U");
        morseMap.put("...-", "V");
        morseMap.put(".--", "W");
        morseMap.put("-..-", "X");
        morseMap.put("-.--", "Y");
        morseMap.put("--..", "Z");
        morseMap.put(".----", "1");
        morseMap.put("..---", "2");
        morseMap.put("...--", "3");
        morseMap.put("....-", "4");
        morseMap.put(".....", "5");
        morseMap.put("-....", "6");
        morseMap.put("--...", "7");
        morseMap.put("---..", "8");
        morseMap.put("----.", "9");
        morseMap.put("-----", "0");
        morseMap.put(".-.-.-", ".");
        morseMap.put("--..--", ",");
        morseMap.put("..--..", "?");
        morseMap.put("-.-.--", "!");
        StringBuilder convertedMorse = new StringBuilder();
        List<String> words = Arrays.stream(texto.split("   ")).toList();
        words.stream().forEach(word -> {
            Arrays.stream(word.split(" ")).toList().forEach(character -> {
                String c = morseMap.get(character);
                convertedMorse.append(c);
            });
            convertedMorse.append(" ");
        });
        return convertedMorse.toString();
    }
}
