package com.mercadolibre.morse.Controllers;

import com.mercadolibre.morse.Domain.RequestBodyMorse;
import com.mercadolibre.morse.Services.IMorseToAlphabetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MorseController {

    @Autowired
    IMorseToAlphabetService morseToAlphabetService;

    @PostMapping("/")
    public String morseToAlphabet(@RequestBody RequestBodyMorse morseCode) {
        return morseToAlphabetService.parseMorseToAlphabet(morseCode.getBody());
    }

}
