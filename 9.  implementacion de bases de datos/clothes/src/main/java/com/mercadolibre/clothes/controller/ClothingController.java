package com.mercadolibre.clothes.controller;

import com.mercadolibre.clothes.model.dto.request.ClothingRequestDTO;
import com.mercadolibre.clothes.model.dto.response.ClothingResponseDTO;
import com.mercadolibre.clothes.model.dto.response.MessageResponse;
import com.mercadolibre.clothes.service.IClothingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clothing")
@RequiredArgsConstructor
public class ClothingController {

    private final IClothingService service;

    @PostMapping
    public ResponseEntity<ClothingResponseDTO> save(@RequestBody ClothingRequestDTO dto){
        System.out.println(dto);
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<ClothingResponseDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<ClothingResponseDTO> getById(@PathVariable Long code){
        return ResponseEntity.ok(service.getById(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<ClothingResponseDTO> update(@PathVariable Long code, @RequestBody ClothingRequestDTO dto){
        return ResponseEntity.ok(service.update(code, dto));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<MessageResponse> delete(@PathVariable Long code){
        return ResponseEntity.ok(service.delete(code));
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<ClothingResponseDTO>> getBySize(@PathVariable String size){
        return ResponseEntity.ok(service.getBySize(size));
    }

    @GetMapping("/name")
    public ResponseEntity<List<ClothingResponseDTO>> getByName(@RequestParam(required = true) String name){
        return ResponseEntity.ok(service.getByNameContains(name));
    }
}
