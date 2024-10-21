package com.meli.joyerialasperlas.controller;

import com.meli.joyerialasperlas.dto.JewelRequestDto;
import com.meli.joyerialasperlas.service.IJewelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
@Validated
public class JewelController {
    @Autowired
    IJewelService jewelService;

    @PostMapping("/new")
    public ResponseEntity<?> newJewel(@RequestBody @Valid JewelRequestDto newJewel){
        return new ResponseEntity<>(jewelService.newJewel(newJewel), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> listJewelry(){
        return new ResponseEntity<>(jewelService.listJewelry(), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable @Valid Long id){
        return new ResponseEntity<>(jewelService.deleteJewel(id), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateJewel(@PathVariable Long id, @RequestBody @Valid JewelRequestDto newJewel){
        return new ResponseEntity<>(jewelService.updateJewel(id, newJewel), HttpStatus.OK);
    }

}
