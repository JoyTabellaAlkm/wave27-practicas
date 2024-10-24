package com.meli.obrasliterarias.controller;

import com.meli.obrasliterarias.dto.ObraLiterariaDto;
import com.meli.obrasliterarias.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class ObraLiterariaController {
    @Autowired
    IObraLiterariaService obraLiterariaService;

    @PostMapping("/new")
    public ResponseEntity<?> createBook(@RequestBody ObraLiterariaDto newBook){
        return new ResponseEntity<>(obraLiterariaService.createBook(newBook), HttpStatus.OK);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<?> findByAutor(@PathVariable String autor){
        return new ResponseEntity<>(obraLiterariaService.findByAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/title/{word}")
    public ResponseEntity<?> findByWordInTitle(@PathVariable String word){
        return new ResponseEntity<>(obraLiterariaService.findByWordInTitle(word), HttpStatus.OK);
    }

    @GetMapping("/topFiveByPages")
    public ResponseEntity<?> topFiveByPages(){
        return new ResponseEntity<>(obraLiterariaService.topFiveByPages(), HttpStatus.OK);
    }

    @GetMapping("/findByYear/{year}")
    public ResponseEntity<?> findByYear(@PathVariable String year){
        return new ResponseEntity<>(obraLiterariaService.findByYear(year), HttpStatus.OK);
    }

    @GetMapping("/findByEditorial/{editorial}")
    public ResponseEntity<?> findByEditorial(@PathVariable String editorial){
        return new ResponseEntity<>(obraLiterariaService.findByEditorial(editorial), HttpStatus.OK);
    }
}
