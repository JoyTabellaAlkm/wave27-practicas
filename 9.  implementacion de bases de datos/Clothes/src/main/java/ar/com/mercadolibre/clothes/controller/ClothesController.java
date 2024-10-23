package ar.com.mercadolibre.clothes.controller;

import ar.com.mercadolibre.clothes.entity.Clothes;
import ar.com.mercadolibre.clothes.service.IClothesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {
    private final IClothesService clothesService;

    public ClothesController(IClothesService clothesService){this.clothesService=clothesService;}

    @PostMapping
    public ResponseEntity<?> createClothes(@RequestBody Clothes clothes){
        return ResponseEntity.ok(clothesService.save(clothes));
    }

    @GetMapping
    public ResponseEntity<?> findAllClothes(){
        return ResponseEntity.ok(clothesService.findAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> findClothes(@PathVariable Long code){
        return ResponseEntity.ok(clothesService.findClothes(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updateClothes(@PathVariable Long code, @RequestBody Clothes clothes){
        return ResponseEntity.ok(clothesService.updateClothes(code, clothes));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteClothes(@PathVariable Long code){
        return ResponseEntity.ok(clothesService.deleteClothes(code));
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> findAllClothesSize(@PathVariable Double size){
        return ResponseEntity.ok(clothesService.findAllBySize(size));
    }

    @GetMapping(params = "name")
    public ResponseEntity<?> findAllClothesName(@RequestParam String name){
        return ResponseEntity.ok(clothesService.findAllByName(name));
    }
}
