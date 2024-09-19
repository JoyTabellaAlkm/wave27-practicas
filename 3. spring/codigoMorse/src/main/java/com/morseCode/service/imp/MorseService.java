package com.morseCode.service.imp;

import com.morseCode.service.iMorseService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MorseService implements iMorseService {
    private Map<String, String> morseToLetter = new HashMap<>();

    public MorseService() {
        populateMap();
    }

    @Override
    public String parseMorseToText(String morse) {
        List<String> morseWords = Arrays.stream(morse.split(" {3}")).toList();

        return String.join(" ", morseWords.stream()
                .map(this::parseWordsMorseToText).toList());
    }

    private String parseWordsMorseToText(String morseWord) {
        return String.join("", Arrays.stream(morseWord.split(" "))
                .map(morseToLetter::get).toList());
    }

    // Completamos mapa
    private void populateMap() {
        morseToLetter.put(".-.-.-", ".");
        morseToLetter.put("-.-.--", "!");
        morseToLetter.put("···−−−···", "SOS");
        morseToLetter.put(".-", "A");
        morseToLetter.put("-...", "B");
        morseToLetter.put("-.-.", "C");
        morseToLetter.put("-..", "D");
        morseToLetter.put(".", "E");
        morseToLetter.put("..-.", "F");
        morseToLetter.put("--.", "G");
        morseToLetter.put("....", "H");
        morseToLetter.put("..", "I");
        morseToLetter.put(".---", "J");
        morseToLetter.put("-.-", "K");
        morseToLetter.put(".-..", "L");
        morseToLetter.put("--", "M");
        morseToLetter.put("-.", "N");
        morseToLetter.put("---", "O");
        morseToLetter.put(".--.", "P");
        morseToLetter.put("--.-", "Q");
        morseToLetter.put(".-.", "R");
        morseToLetter.put("...", "S");
        morseToLetter.put("-", "T");
        morseToLetter.put("..-", "U");
        morseToLetter.put("...-", "V");
        morseToLetter.put(".--", "W");
        morseToLetter.put("-..-", "X");
        morseToLetter.put("-.--", "Y");
        morseToLetter.put("--..", "Z");
        morseToLetter.put(".----", "1");
        morseToLetter.put("..---", "2");
        morseToLetter.put("...--", "3");
        morseToLetter.put("....-", "4");
        morseToLetter.put(".....", "5");
        morseToLetter.put("_....", "6");
        morseToLetter.put("__...", "7");
        morseToLetter.put("___..", "8");
        morseToLetter.put("____.", "9");
        morseToLetter.put("_____", "0");
    }
}
