package com.mercadolibre.practicadeportista.controller;

import com.mercadolibre.practicadeportista.model.Deporte;
import com.mercadolibre.practicadeportista.model.DeportistaDTO;
import com.mercadolibre.practicadeportista.service.IDeportista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deportes")
public class ControllerDeportes {
    @Autowired
    IDeportista deportista;

    @GetMapping("/findSports")
    public ResponseEntity<?> findSports() {
        List<Deporte> response = deportista.obtenerLista();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> getSport(@PathVariable String name) {
        Deporte response = deportista.getDeporte(name);
        return ResponseEntity.ok(response);
    }
    @GetMapping("findSportsPersons")
    public ResponseEntity<?> findSportsPersons() {
        List<DeportistaDTO> response = deportista.getDeportistas();
        return ResponseEntity.ok(response);
    }
}
