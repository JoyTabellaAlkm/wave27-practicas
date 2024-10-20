package com.example.joyeriajpa.controller;

import com.example.joyeriajpa.dto.ResponseActDTO;
import com.example.joyeriajpa.dto.ResponseDTO;
import com.example.joyeriajpa.model.Jewel;
import com.example.joyeriajpa.service.IJewerlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewerlyController {

    @Autowired
    private IJewerlyService jewerlyService;

    @PostMapping("/new")
    public ResponseEntity<?> createJewel(@RequestBody Jewel jewel) {
        jewerlyService.saveJewel(jewel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDTO<>("Se creo la joya con el numero de identificacion: " + jewel.getId(), 201));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getJewels() {
        List<Jewel> jewels = jewerlyService.getJewels();
        return ResponseEntity.ok(new ResponseDTO<>(jewels, 200));
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> updateJewel(@PathVariable int id_modificar, @RequestBody Jewel updatedJewel) {
        Jewel jewel = jewerlyService.updateJewel(id_modificar, updatedJewel);
        return ResponseEntity.ok(new ResponseActDTO<>(jewel,"Se actualizó correctamente la joya.", 200));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable int id) {
        jewerlyService.deleteJewel(id);
        return ResponseEntity.ok(new ResponseDTO<>("Se elimino la joya correctamente",200));
    }
}
