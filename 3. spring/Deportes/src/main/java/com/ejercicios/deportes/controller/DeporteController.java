package com.ejercicios.deportes.controller;

import com.ejercicios.deportes.dto.DeporteDTO;
import com.ejercicios.deportes.model.Deporte;
import com.ejercicios.deportes.service.IDeporteService;
import lombok.Data;
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
    IDeporteService iDeporteService;

    @GetMapping("/findSports")
    public ResponseEntity<?> verDeportes() {
        List<DeporteDTO> listaDeportes = iDeporteService.verDeportes();
        if (listaDeportes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaDeportes);
    }

    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<?> verDeportes(@PathVariable String nombre) {
        DeporteDTO deporteDTO = iDeporteService.verDeportesPorNombre(nombre);
        if (deporteDTO == null) {
            return ResponseEntity.badRequest().body("No se encontró ningún deporte con ese nombre.");
        }
        return ResponseEntity.ok(deporteDTO);
    }
}
