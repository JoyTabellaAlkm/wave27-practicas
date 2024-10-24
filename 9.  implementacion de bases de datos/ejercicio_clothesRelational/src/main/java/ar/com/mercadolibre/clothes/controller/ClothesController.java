package ar.com.mercadolibre.clothes.controller;

import ar.com.mercadolibre.clothes.dto.request.ClothesRequestDto;
import ar.com.mercadolibre.clothes.service.IClothesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/clothes")
@Validated
public class ClothesController {
    private final IClothesService clothesService;

    @Autowired
    public ClothesController(IClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @PostMapping
    public ResponseEntity<?> createClothes(@Valid @RequestBody ClothesRequestDto clothes) {
        return ResponseEntity.ok(clothesService.createClothes(clothes));
    }

    @GetMapping
    public ResponseEntity<?> findAllClothes() {
        return ResponseEntity.ok(clothesService.findAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> findClothes(@PathVariable Long code) {
        return ResponseEntity.ok(clothesService.findClothes(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updateClothes(@PathVariable Long code, @Valid @RequestBody ClothesRequestDto clothes) {
        return ResponseEntity.ok(clothesService.updateClothes(code, clothes));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteClothes(@PathVariable Long code) {
        return ResponseEntity.ok(clothesService.deleteClothes(code));
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> findAllClothesSize(@PathVariable @Positive(message = "El tamaño debe ser positivo") Double size) {
        return ResponseEntity.ok(clothesService.findAllBySize(size));
    }

    @GetMapping(params = "name")
    public ResponseEntity<?> findAllClothesName(@RequestParam @NotBlank(message = "El nombre no puede estar vacío") String name) {
        return ResponseEntity.ok(clothesService.findAllByName(name));
    }
}
