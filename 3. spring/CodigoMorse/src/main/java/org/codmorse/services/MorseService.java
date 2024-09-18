package org.codmorse.services;

import org.codmorse.exceptions.CaracterInvalidoException;
import org.codmorse.repositories.MorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MorseService {
    @Autowired
    private MorseRepository morseRepository;

    public String getMorseCode(String morseCode) throws CaracterInvalidoException {
        StringBuilder returnString = new StringBuilder();
        List<String> palabrasMorse = List.of(morseCode.split(" {3}"));

        for(String palabraMorse : palabrasMorse){
            for(String caracterMorse : Arrays.stream(palabraMorse.split(" ")).toList()){
                if(morseRepository.getValue(caracterMorse) != null) {
                    returnString.append(morseRepository.getValue(caracterMorse));
                    continue;
                }
                throw new CaracterInvalidoException(caracterMorse);

            }
            returnString.append(" ");
        }

        return returnString.toString();
    }
}
