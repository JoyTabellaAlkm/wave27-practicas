package co.com.mercadolibre.morse.service.impl;

import co.com.mercadolibre.morse.service.IEncriptado;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseService implements IEncriptado {
    private static HashMap<String,String> morseMap = new HashMap<>();
    static {
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
    }

    @Override
    public String coder(String texto) {
        StringBuilder resultado = new StringBuilder();
        String[] palabras = texto.split("\\s{3}");
        for (String palabra: palabras){
            String[] letras = palabra.split("\\s");
            for (String letra: letras){
                resultado.append(morseMap.get(letra));
            }
            resultado.append(" ");
        }
        return String.valueOf(resultado);
    }

    @Override
    public String decoder(String texto) {
        StringBuilder resultado = new StringBuilder();
        char[] textoAEncriptar = texto.toUpperCase().toCharArray();
        for (char letra: textoAEncriptar){
            resultado.append(morseMap.entrySet().stream().filter(entrada -> String.valueOf(letra).equals(entrada.getValue()))
                    .findFirst().map(Map.Entry::getKey).orElse("  ")).append(" ");
        }
        return String.valueOf(resultado);
    }
}
