package com.example.MorseCode.services;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeTranslator {

    private static final Map<String, String> morseToTextMap = new HashMap<>();

    static {
        morseToTextMap.put(".-", "A");
        morseToTextMap.put("-...", "B");
        morseToTextMap.put("-.-.", "C");
        morseToTextMap.put("-..", "D");
        morseToTextMap.put(".", "E");
        morseToTextMap.put("..-.", "F");
        morseToTextMap.put("--.", "G");
        morseToTextMap.put("....", "H");
        morseToTextMap.put("..", "I");
        morseToTextMap.put(".---", "J");
        morseToTextMap.put("-.-", "K");
        morseToTextMap.put(".-..", "L");
        morseToTextMap.put("--", "M");
        morseToTextMap.put("-.", "N");
        morseToTextMap.put("---", "O");
        morseToTextMap.put(".--.", "P");
        morseToTextMap.put("--.-", "Q");
        morseToTextMap.put(".-.", "R");
        morseToTextMap.put("...", "S");
        morseToTextMap.put("-", "T");
        morseToTextMap.put("..-", "U");
        morseToTextMap.put("...-", "V");
        morseToTextMap.put(".--", "W");
        morseToTextMap.put("-..-", "X");
        morseToTextMap.put("-.--", "Y");
        morseToTextMap.put("--..", "Z");
        morseToTextMap.put("-----", "0");
        morseToTextMap.put(".----", "1");
        morseToTextMap.put("..---", "2");
        morseToTextMap.put("...--", "3");
        morseToTextMap.put("....-", "4");
        morseToTextMap.put(".....", "5");
        morseToTextMap.put("-....", "6");
        morseToTextMap.put("--...", "7");
        morseToTextMap.put("---..", "8");
        morseToTextMap.put("----.", "9");
        // Añadir más caracteres especiales si es necesario
    }

    public static String translate(String morseCode) {
        StringBuilder result = new StringBuilder();
        String[] words = morseCode.trim().split("   "); // Separar por 3 espacios para palabras

        for (String word : words) {
            String[] characters = word.split(" "); // Separar por 1 espacio para caracteres
            for (String character : characters) {
                result.append(morseToTextMap.getOrDefault(character, "?"));
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}

