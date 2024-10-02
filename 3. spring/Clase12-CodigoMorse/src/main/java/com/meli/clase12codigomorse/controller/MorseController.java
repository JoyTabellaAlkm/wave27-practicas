package com.meli.clase12codigomorse.controller;

import com.meli.clase12codigomorse.service.IMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
public class MorseController {
    @Autowired
    IMorseService morseService;

    @GetMapping("/{morseCode}")
    public ResponseEntity<?> decodeMorse(@PathVariable String morseCode){
        return new ResponseEntity<>(morseService.decodeMorse(morseCode), HttpStatus.OK);
    }
}
