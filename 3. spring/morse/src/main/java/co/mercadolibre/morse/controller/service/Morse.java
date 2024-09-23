package co.mercadolibre.morse.controller.service;

import co.mercadolibre.morse.controller.service.impL.IMorse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Morse implements IMorse {

    @Override
    public String traduccion(String texto) {
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
        morseMap.put("..--..", "?");
        morseMap.put("-.-.--", "!");
        morseMap.put(".-.-.-", ".");
        morseMap.put("--..--", ",");

        StringBuilder resultado = new StringBuilder();

        String[] palabras = texto.split("\\s{3}");

        for (String palabra : palabras) {
            String[] letras = palabra.split("\\s{1}");
            System.out.println("palabra = |"+palabra+"|");

            for (String letra : letras) {

                System.out.println("letra = |" + letra + "|");
                resultado.append(morseMap.get(letra));

            }

            System.out.println("|"+resultado+"|");
            resultado.append(" ");
        }


        return resultado.toString();
    }
}
