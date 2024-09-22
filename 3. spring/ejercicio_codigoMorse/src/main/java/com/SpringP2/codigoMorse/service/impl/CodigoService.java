package com.SpringP2.codigoMorse.service.impl;

import com.SpringP2.codigoMorse.service.ICodigoService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CodigoService implements ICodigoService {

    Map<Character, String> morseCodeMap = new HashMap<>();

    @Override
    public String decodificador(String codigo) {
        this.inicializador();
        String[] frase = codigo.split("  ");
        String[] palabritas = {""};

        for (String palabra : frase) {
            palabritas = palabra.split(" ");
        }

        StringBuilder stringBuilder = new StringBuilder();
        char letrita = ' ';

        for (String letra : palabritas) {
            letrita = this.convertirPalabra(letra);
            stringBuilder.append(letrita);
        }

        return stringBuilder.toString();
    }

    @Override
    public char convertirPalabra(String codigo) {
        char letra = ' ';

        for (Map.Entry<Character, String> mapa : morseCodeMap.entrySet()) {
            if (mapa.getValue().equals(codigo)) {
                letra = mapa.getKey();
            }
        }

        return letra;
    }

    public void inicializador() {
        // Agregar datos al HashMap
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
    }

}
