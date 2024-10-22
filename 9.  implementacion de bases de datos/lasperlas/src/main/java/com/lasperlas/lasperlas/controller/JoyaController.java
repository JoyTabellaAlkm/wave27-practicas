package com.lasperlas.lasperlas.controller;


import com.lasperlas.lasperlas.dto.JoyaDTO;
import com.lasperlas.lasperlas.service.IJoyaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JoyaController {
    private final IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/jewerly/new")
    ResponseEntity<?> createJewel(@RequestBody JoyaDTO joyaDTO) {
        return ResponseEntity.ok(joyaService.create(joyaDTO));
    }

    @GetMapping("/jewerly")
    ResponseEntity<?> getAllJewels() {
        return ResponseEntity.ok(joyaService.getAll());
    }

    @DeleteMapping("/jewerly/delete/{id}")
    ResponseEntity<?> deleteJewel(@PathVariable Long id) {
        return ResponseEntity.ok(joyaService.delete(id));
    }

    @PutMapping("/jewerly/update/{id}")
    ResponseEntity<?> updateJewel(@PathVariable Long id, @RequestBody JoyaDTO joyaDTO) {
        return ResponseEntity.ok(joyaService.update(id, joyaDTO));
    }
}
