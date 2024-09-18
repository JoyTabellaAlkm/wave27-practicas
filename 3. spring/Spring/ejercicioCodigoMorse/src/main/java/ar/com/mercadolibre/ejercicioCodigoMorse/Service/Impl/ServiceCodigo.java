package ar.com.mercadolibre.ejercicioCodigoMorse.Service.Impl;

import ar.com.mercadolibre.ejercicioCodigoMorse.Service.IService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class ServiceCodigo implements IService {

    @Override
    public String convertirCodigo(String inputUrl) {
        List<String> input = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2",
                "3", "4", "5", "6", "7", "8", "9", "0", "?", "!", ".", ","));
        List<String> output = new ArrayList<>(Arrays.asList(".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...",
                "---..", "----.", "-----", "..--..", "-.-.--", ".-.-.-", "--..--"));
        StringBuilder codigoMorse = new StringBuilder();

        for(char i : inputUrl.toUpperCase(Locale.ROOT).toCharArray()){
            if (i == ' '){
                codigoMorse.append("   "); // para separar entre palabras
            }
            else{
                String caracter = String.valueOf(i);
                int index = input.indexOf(caracter);
                if(index != -1){
                    codigoMorse.append(output.get(index)).append(" ");
                }
            }
        }
        return codigoMorse.toString().trim();
    }

    @Override
    public String convertirEspaniol(String inputUrl){
        List<String> input = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2",
                "3", "4", "5", "6", "7", "8", "9", "0", "?", "!", ".", ","));
        List<String> output = new ArrayList<>(Arrays.asList(".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...",
                "---..", "----.", "-----", "..--..", "-.-.--", ".-.-.-", "--..--"));
        StringBuilder codigoMorse = new StringBuilder();

        String[] palabras = inputUrl.split(" {3}"); // identifico una palabra

        for (String palabraMorse : palabras) {
            String[] caracteresMorse = palabraMorse.split(" "); // una letra en codigo morse va a tener un espacio
            for (String caracterMorse : caracteresMorse) {
                int index = output.indexOf(caracterMorse);
                if (index != -1) {
                    codigoMorse.append(input.get(index));
                }
            }
            codigoMorse.append(" ");
        }
        return codigoMorse.toString().trim();

    }
}
