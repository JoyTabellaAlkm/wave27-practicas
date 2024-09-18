package ar.com.codigomorse.codigo.service.impl;

import ar.com.codigomorse.codigo.service.ICodigoMorseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CodigoMorseService implements ICodigoMorseService {
    private HashMap<String, String> alphaMorse = new HashMap<>();

    public void cargarDiccionario() {
        alphaMorse.put("A", ".-");
        alphaMorse.put("B", "-...");
        alphaMorse.put("C", "-.-.");
        alphaMorse.put("D", "-..");
        alphaMorse.put("E", ".");
        alphaMorse.put("F", "..-.");
        alphaMorse.put("G", "--.");
        alphaMorse.put("H", "....");
        alphaMorse.put("I", "..");
        alphaMorse.put("J", ".---");
        alphaMorse.put("K", "-.-");
        alphaMorse.put("L", ".-..");
        alphaMorse.put("M", "--");
        alphaMorse.put("N", "-.");
        alphaMorse.put("O", "---");
        alphaMorse.put("P", ".--.");
        alphaMorse.put("Q", "--.-");
        alphaMorse.put("R", ".-.");
        alphaMorse.put("S", "...");
        alphaMorse.put("T", "-");
        alphaMorse.put("U", "..-");
        alphaMorse.put("V", "...-");
        alphaMorse.put("W", ".--");
        alphaMorse.put("X", "-..-");
        alphaMorse.put("y", "-.--");
        alphaMorse.put("z", "--..");
        alphaMorse.put("1", ".----");
        alphaMorse.put("2", "..---");
        alphaMorse.put("3", "...--");
        alphaMorse.put("4", "....-");
        alphaMorse.put("5", ".....");
        alphaMorse.put("6", "-....");
        alphaMorse.put("7", "--...");
        alphaMorse.put("8", "---..");
        alphaMorse.put("9", "----.");
        alphaMorse.put("0", "-----");
        alphaMorse.put(" ", "|");
        alphaMorse.put("?", "..--..");
        alphaMorse.put("!", "-.-.--");
        alphaMorse.put(".", ".-.-.-");
        alphaMorse.put(",", "--..--");
    }

    @Override
    public String decodificador(String codigo) {
        cargarDiccionario();

        String[] dividiendoCodigoLetra = codigo.split(" ");

        StringBuilder mensaje =  new StringBuilder();

        for (int i = 0; i < dividiendoCodigoLetra.length; i++) {
            for (Map.Entry<String, String> entry : alphaMorse.entrySet()) {
                if (entry.getValue().equals(dividiendoCodigoLetra[i])) {
                    mensaje.append(entry.getKey());
                }
            }
        }
        //String[] dividiendoCodigoFrase = codigo.split("   ");
        return mensaje.toString();
    }
}
