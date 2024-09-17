package ar.com.mercadolibre.morse.controller;

import ar.com.mercadolibre.morse.service.IMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MorseController {
    @Autowired
    private IMorseService morseService;

    @GetMapping("/morseToText")
    public String morseToText(@RequestParam String morse) {
        return morseService.parseMorseToText(morse);
    }
}
