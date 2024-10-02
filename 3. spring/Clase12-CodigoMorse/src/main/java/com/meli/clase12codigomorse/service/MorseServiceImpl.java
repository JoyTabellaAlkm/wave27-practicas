package com.meli.clase12codigomorse.service;

import com.meli.clase12codigomorse.dto.MorseCodeDTO;
import com.meli.clase12codigomorse.repository.MorseCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class MorseServiceImpl implements IMorseService{
    @Autowired
    MorseCodeRepository morseCodeRepository;

    @Override
    public MorseCodeDTO decodeMorse(String morseCode) {
        StringBuilder decoded = new StringBuilder();

        List<List<String>> words = Stream.of(morseCode.split("   "))
                .map(word -> Stream.of(word.split(" ")))
                .map(word ->
                        word.map(letter -> morseCodeRepository.findAll().get(letter)).toList()
                ).toList();
         for (List<String> word : words){
             for (String letter : word){
                 decoded.append(letter);
             }
             decoded.append(" ");
         }
        return new MorseCodeDTO(morseCode, decoded.toString());
    }

}
