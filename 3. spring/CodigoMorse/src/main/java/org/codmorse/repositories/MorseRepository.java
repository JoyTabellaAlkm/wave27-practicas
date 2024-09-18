package org.codmorse.repositories;

import org.codmorse.exceptions.CaracterInvalidoException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MorseRepository {
    private final Map<String, String> morseCodeDictionary = new HashMap<>();

    public MorseRepository() {
        morseCodeDictionary.put(".-", "A");
        morseCodeDictionary.put("-...", "B");
        morseCodeDictionary.put("-.-.", "C");
        morseCodeDictionary.put("-..", "D");
        morseCodeDictionary.put(".", "E");
        morseCodeDictionary.put("..-.", "F");
        morseCodeDictionary.put("--.", "G");
        morseCodeDictionary.put("....", "H");
        morseCodeDictionary.put("..", "I");
        morseCodeDictionary.put(".---", "J");
        morseCodeDictionary.put("-.-", "K");
        morseCodeDictionary.put(".-..", "L");
        morseCodeDictionary.put("--", "M");
        morseCodeDictionary.put("-.", "N");
        morseCodeDictionary.put("---", "O");
        morseCodeDictionary.put(".--.", "P");
        morseCodeDictionary.put("--.-", "Q");
        morseCodeDictionary.put(".-.", "R");
        morseCodeDictionary.put("...", "S");
        morseCodeDictionary.put("-", "T");
        morseCodeDictionary.put("..-", "U");
        morseCodeDictionary.put("...-", "V");
        morseCodeDictionary.put(".--", "W");
        morseCodeDictionary.put("-..-", "X");
        morseCodeDictionary.put("-.--", "Y");
        morseCodeDictionary.put("--..", "Z");
        morseCodeDictionary.put(".----", "1");
        morseCodeDictionary.put("..---", "2");
        morseCodeDictionary.put("...--", "3");
        morseCodeDictionary.put("....-", "4");
        morseCodeDictionary.put(".....", "5");
        morseCodeDictionary.put("-....", "6");
        morseCodeDictionary.put("--...", "7");
        morseCodeDictionary.put("---..", "8");
        morseCodeDictionary.put("----.", "9");
        morseCodeDictionary.put("-----", "0");
        morseCodeDictionary.put(".-.-.-", ".");
        morseCodeDictionary.put("--..--", ",");
        morseCodeDictionary.put("..--..", "?");
        morseCodeDictionary.put("-.-.--", "!");
    }

    public String getValue(String morseCode) {
        return morseCodeDictionary.get(morseCode);
    }
}
