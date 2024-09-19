package com.bootcamp.pruebaspring.morseCode.service.impl;


import com.bootcamp.pruebaspring.morseCode.service.IMorseCodeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseCodeServiceImpl implements IMorseCodeService {

    private static final Map<String, String> morseToAlphabet = new HashMap<>();

    static {
        morseToAlphabet.put(".-", "A");
        morseToAlphabet.put("-...", "B");
        morseToAlphabet.put("-.-.", "C");
        morseToAlphabet.put("-..", "D");
        morseToAlphabet.put(".", "E");
        morseToAlphabet.put("..-.", "F");
        morseToAlphabet.put("--.", "G");
        morseToAlphabet.put("....", "H");
        morseToAlphabet.put("..", "I");
        morseToAlphabet.put(".---", "J");
        morseToAlphabet.put("-.-", "K");
        morseToAlphabet.put(".-..", "L");
        morseToAlphabet.put("--", "M");
        morseToAlphabet.put("-.", "N");
        morseToAlphabet.put("---", "O");
        morseToAlphabet.put(".--.", "P");
        morseToAlphabet.put("--.-", "Q");
        morseToAlphabet.put(".-.", "R");
        morseToAlphabet.put("...", "S");
        morseToAlphabet.put("-", "T");
        morseToAlphabet.put("..-", "U");
        morseToAlphabet.put("...-", "V");
        morseToAlphabet.put(".--", "W");
        morseToAlphabet.put("-..-", "X");
        morseToAlphabet.put("-.--", "Y");
        morseToAlphabet.put("--..", "Z");
    }

    public String translateMorseToText(String morseCode) {
        StringBuilder translatedText = new StringBuilder();
        String[] morseWords = morseCode.trim().split("   ");

        for (String word : morseWords) {
            String[] morseChars = word.split(" ");

            for (String character : morseChars) {
                String letter = morseToAlphabet.get(character);
                translatedText.append(letter);
            }

            translatedText.append(" ");
        }

        return translatedText.toString().trim();
    }


    public String translateTextToMorse(String text) {
        StringBuilder translatedMorse = new StringBuilder();
        String[] textWords = text.trim().split(" ");

        for (String word : textWords) {

            for (int i = 0; i < word.length(); i++) {

                for (Map.Entry<String, String> entry: morseToAlphabet.entrySet()){
                    if (entry.getValue().equals((String.valueOf(word.charAt(i))))){
                        translatedMorse.append(entry.getKey());
                    }

                }
                translatedMorse.append(" ");
            }
            translatedMorse.append("  ");

        }

        return translatedMorse.toString().trim();


    }
}
