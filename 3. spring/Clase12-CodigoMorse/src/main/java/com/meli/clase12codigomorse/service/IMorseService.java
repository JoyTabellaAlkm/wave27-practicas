package com.meli.clase12codigomorse.service;

import com.meli.clase12codigomorse.dto.MorseCodeDTO;

public interface IMorseService {
    public MorseCodeDTO decodeMorse(String morseCode);
}
