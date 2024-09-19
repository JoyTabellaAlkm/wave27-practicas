package com.bootcamp.pruebaspring.morseCode.service;

public interface IMorseCodeService {
    String translateMorseToText(String morseCode);

    String translateTextToMorse(String text);
}
