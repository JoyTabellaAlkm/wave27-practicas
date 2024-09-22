package com.example.deportistas.controller;

import com.example.deportistas.dto.DeporteDTO;
import com.example.deportistas.entity.Nivel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SportsRestController {
    private List<DeporteDTO> deportesDTO = new ArrayList<>();

    public SportsRestController(List<DeporteDTO> deportesDTO) {
        this.deportesDTO = deportesDTO;
        fillSportsList();
    }

    @GetMapping("/findSports")
    public ResponseEntity<?> findAllSports() {
        return new ResponseEntity<>("Los deportes son: " + deportesDTO, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        Nivel nivel = deportesDTO.stream()
                .filter(d -> d.getNombre().equals(name))
                .findFirst().orElseGet(null)
                .getNivel();

        return new ResponseEntity<>(nivel, HttpStatus.OK);
    }

    public void fillSportsList() {
    DeporteDTO futbol = new DeporteDTO("Futbol", Nivel.ALTO);
    DeporteDTO baloncesto = new DeporteDTO("Baloncesto", Nivel.MEDIO);
    DeporteDTO tenis = new DeporteDTO("Tenis", Nivel.BAJO);

    deportesDTO.add(futbol);
    deportesDTO.add(baloncesto);
    deportesDTO.add(tenis);
}
}
