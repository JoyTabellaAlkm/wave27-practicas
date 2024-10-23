package org.mercadolibre.ejercicio2joyeria.controller;

import org.mercadolibre.ejercicio2joyeria.dto.request.JewelDTO;
import org.mercadolibre.ejercicio2joyeria.service.IJewelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JewelController {
    private final IJewelService iJewelService;

    public JewelController(IJewelService iJewelService) {
        this.iJewelService = iJewelService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createJewel(@RequestBody JewelDTO jewelDTO){
        return new ResponseEntity<>(iJewelService.createJewel(jewelDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllJewel(){
        return new ResponseEntity<>(iJewelService.getAllJewel(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable Long id){
        return new ResponseEntity<>(iJewelService.deleteJewel(id) , HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJewel(@PathVariable Long id, @RequestBody JewelDTO jewelDTO){
        return new ResponseEntity<>(iJewelService.updateJewel(id, jewelDTO) , HttpStatus.OK);
    }
}
