package com.mercadolibre.clothes.controller;

import com.mercadolibre.clothes.model.dto.request.SaleRequestDTO;
import com.mercadolibre.clothes.model.dto.response.MessageResponse;
import com.mercadolibre.clothes.model.dto.response.SaleResponseDTO;
import com.mercadolibre.clothes.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class SaleController {

    private final ISaleService service;

    @PostMapping
    public ResponseEntity<SaleResponseDTO> save(@RequestBody SaleRequestDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<SaleResponseDTO> getSaleByCode(@PathVariable Long code){
        return ResponseEntity.ok(service.getSaleByCode(code));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<MessageResponse> delete(@PathVariable Long code){
        return ResponseEntity.ok(service.delete(code));
    }

    @GetMapping("/date")
    public ResponseEntity<List<SaleResponseDTO>> getByDate(@RequestParam LocalDate date){
        return ResponseEntity.ok(service.getByDate(date));
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<SaleResponseDTO>> getByClothesNumber(@PathVariable Integer number){
        return ResponseEntity.ok(service.getByClothesNumber(number));
    }
}
