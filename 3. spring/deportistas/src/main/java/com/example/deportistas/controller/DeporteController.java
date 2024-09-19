package com.example.deportistas.controller;

import com.example.deportistas.dto.DeporteDTO;
import com.example.deportistas.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    @Autowired
    private DeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<?> findAllSports() {
        List<DeporteDTO> deportesDTO = deporteService.findAll();
        return new ResponseEntity<>("Los deportes son: " + deportesDTO, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        DeporteDTO deporteDTO = deporteService.findByName(name);
        return new ResponseEntity<>(deporteDTO, HttpStatus.OK);
    }
}
