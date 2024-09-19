package com.bootcamp.pruebaspring.morseCode.controller;


import com.bootcamp.pruebaspring.morseCode.service.IMorseCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseCodeController {

    private final IMorseCodeService morseCodeService;

    public MorseCodeController(IMorseCodeService morseCodeService){
        this.morseCodeService = morseCodeService;
    }


    @GetMapping("/totext/{morseCode}")
    public String translateMorseCode(@PathVariable String morseCode){
        return morseCodeService.translateMorseToText(morseCode);
    }

    @GetMapping("/tomorse/{text}")
    public String translateText(@PathVariable String text){
        return morseCodeService.translateTextToMorse(text);
    }

}
