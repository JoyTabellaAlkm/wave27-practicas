package com.example.MorseCode.controller;

import com.example.MorseCode.services.MorseCodeTranslator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @GetMapping("/api/translate")
    public ResponseEntity<String> translateMorseCode(@RequestParam String morseCode) {
        String translatedText = MorseCodeTranslator.translate(morseCode);
        return ResponseEntity.ok(translatedText);
    }
}

