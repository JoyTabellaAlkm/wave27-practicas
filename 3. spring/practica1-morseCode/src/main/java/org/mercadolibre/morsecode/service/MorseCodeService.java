package org.mercadolibre.morsecode.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseCodeService implements IMorseCodeService{
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

    @Override
    public String traduccion(String code) {
        StringBuilder traslate = new StringBuilder();
        String[] morseWords = code.trim().split("   ");
        for (String word : morseWords){
            String[] morseChars = word.split(" ");
            for (String character: morseChars){
                String letter = morseToAlphabet.get(character);
                traslate.append(letter);
            }
            traslate.append(" ");
        }
        return traslate.toString();

    }

    @Override
    public String alReves(String palabra) {

        return "";
    }


}
