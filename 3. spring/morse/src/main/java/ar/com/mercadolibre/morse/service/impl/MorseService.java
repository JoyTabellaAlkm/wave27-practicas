package ar.com.mercadolibre.morse.service.impl;

import ar.com.mercadolibre.morse.service.IMorseService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MorseService implements IMorseService {
    private final Map<String, String> morseToLetterMap = new HashMap<>();

    public MorseService() {
        populateMap();
    }

    public String parseMorseToText(String morse) {
        List<String> words = Arrays.stream(morse.split(" {3}")).toList();

        return String.join(" ", words.stream()
                .map(this::parseWordsMorseToText).toList());
    }

    private String parseWordsMorseToText(String word) {
        return String.join("", Arrays.stream(word.split(" "))
                .map(morseToLetterMap::get).toList());
    }

    private void populateMap() {
        morseToLetterMap.put(".-.-.-", ".");
        morseToLetterMap.put("-.-.--", "!");
        morseToLetterMap.put("···−−−···", "SOS");
        morseToLetterMap.put(".-", "A");
        morseToLetterMap.put("-...", "B");
        morseToLetterMap.put("-.-.", "C");
        morseToLetterMap.put("-..", "D");
        morseToLetterMap.put(".", "E");
        morseToLetterMap.put("..-.", "F");
        morseToLetterMap.put("--.", "G");
        morseToLetterMap.put("....", "H");
        morseToLetterMap.put("..", "I");
        morseToLetterMap.put(".---", "J");
        morseToLetterMap.put("-.-", "K");
        morseToLetterMap.put(".-..", "L");
        morseToLetterMap.put("--", "M");
        morseToLetterMap.put("-.", "N");
        morseToLetterMap.put("---", "O");
        morseToLetterMap.put(".--.", "P");
        morseToLetterMap.put("--.-", "Q");
        morseToLetterMap.put(".-.", "R");
        morseToLetterMap.put("...", "S");
        morseToLetterMap.put("-", "T");
        morseToLetterMap.put("..-", "U");
        morseToLetterMap.put("...-", "V");
        morseToLetterMap.put(".--", "W");
        morseToLetterMap.put("-..-", "X");
        morseToLetterMap.put("-.--", "Y");
        morseToLetterMap.put("--..", "Z");
        morseToLetterMap.put(".----", "1");
        morseToLetterMap.put("..---", "2");
        morseToLetterMap.put("...--", "3");
        morseToLetterMap.put("....-", "4");
        morseToLetterMap.put(".....", "5");
        morseToLetterMap.put("_....", "6");
        morseToLetterMap.put("__...", "7");
        morseToLetterMap.put("___..", "8");
        morseToLetterMap.put("____.", "9");
        morseToLetterMap.put("_____", "0");
    }
}
