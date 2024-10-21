package com.mercadolibre.joyeria.controller;

import com.mercadolibre.joyeria.dto.request.JoyaRequestDto;
import com.mercadolibre.joyeria.service.IJoyaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/jewelry")
@Validated
public class JoyaController {
    @Autowired
    IJoyaService service;

@PostMapping("/new")
public ResponseEntity<?> createJoya(@RequestBody @Valid JoyaRequestDto joyaDto){
    return new ResponseEntity<>(service.createJoya(joyaDto), HttpStatus.CREATED);
}
@GetMapping
public ResponseEntity<?> getAll(){
    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
}

@PatchMapping("/delete/{id}")
public ResponseEntity<?> deleteById(@PathVariable @Positive(message = "El id debe ser positivo") Long id){
    service.deleteJoya(id);
    return ResponseEntity.ok().build();
}

@PutMapping("/update/{id_modificar}")
public ResponseEntity<?> updateJoya(@PathVariable @Positive(message = "El id debe ser positivo") Long id_modificar, @RequestBody @Valid JoyaRequestDto joyaDto){
    return new ResponseEntity<>(service.updateJoya(id_modificar,joyaDto), HttpStatus.OK);
}
}
