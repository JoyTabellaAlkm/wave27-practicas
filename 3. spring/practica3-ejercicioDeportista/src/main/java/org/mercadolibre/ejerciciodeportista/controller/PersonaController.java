package org.mercadolibre.ejerciciodeportista.controller;

import org.mercadolibre.ejerciciodeportista.dto.DeporteDTO;
import org.mercadolibre.ejerciciodeportista.entity.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    List<Deporte> deportes = List.of(new Deporte(1L, "Futbol", "Basico"), new Deporte(2L, "Natacion", "Avanzado"));


    @GetMapping("/findSports")
    public ResponseEntity<?> findSports(){
        List<DeporteDTO> listaDeportesDTO = new ArrayList<>();
        for(Deporte deporte: deportes){
            listaDeportesDTO.add(new DeporteDTO(deporte.getNombre(), deporte.getNivel()));
        }
        return new ResponseEntity<>(listaDeportesDTO, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<?> findSportByName(@PathVariable String name){
        return new ResponseEntity<>(deportes.stream().filter(deporte -> {
            return deporte.getNombre().equals(name);
        }).findFirst().get(), HttpStatus.OK);
    }
}
