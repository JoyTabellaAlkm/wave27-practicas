package com.mercadolibre.morse.Services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class MorseToAlphabetService implements IMorseToAlphabetService{

    HashMap<String,String> alphabet;

    public MorseToAlphabetService() {
        alphabet = new HashMap<>();
        //A to Z
        alphabet.put(".-","A");
        alphabet.put("-...","B");
        alphabet.put("-.-.","C");
        alphabet.put("-..","D");
        alphabet.put(".","E");
        alphabet.put("..-.","F");
        alphabet.put("--.","G");
        alphabet.put("....","H");
        alphabet.put("..","I");
        alphabet.put(".---","J");
        alphabet.put("-.-","K");
        alphabet.put(".-..","L");
        alphabet.put("--","M");
        alphabet.put("-.","N");
        alphabet.put("---","O");
        alphabet.put(".--.","P");
        alphabet.put("--.-","Q");
        alphabet.put(".-.","R");
        alphabet.put("...","S");
        alphabet.put("-","T");
        alphabet.put("..-","U");
        alphabet.put("...-","V");
        alphabet.put(".--","W");
        alphabet.put("-..-","X");
        alphabet.put("-.--","Y");
        alphabet.put("--..","Z");

        //Numbers
        alphabet.put(".----", "1");
        alphabet.put("..---", "2");
        alphabet.put("...--", "3");
        alphabet.put("....-", "4");
        alphabet.put(".....", "5");
        alphabet.put("-....", "6");
        alphabet.put("--...", "7");
        alphabet.put("---..", "8");
        alphabet.put("----.", "9");
        alphabet.put("-----", "0");

        //Especial characters
        alphabet.put("..--..", "?");
        alphabet.put("-.-.--", "!");
        alphabet.put(".-.-.-", ".");
        alphabet.put("--..--", ",");

        //Espacio
        alphabet.put("", " ");
    }

    @Override
    public String parseMorseToAlphabet(String morse) {

        String[] morseLetters = morse.split(" ");

        String word = "";

        for (String morseLetter : morseLetters) {
            word += alphabet.get(morseLetter);
        }

        word = word.replace("  ", " ");

        return word;
    }
}
