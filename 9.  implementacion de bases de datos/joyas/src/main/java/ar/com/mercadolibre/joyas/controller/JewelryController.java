package ar.com.mercadolibre.joyas.controller;


import ar.com.mercadolibre.joyas.model.Jewelry;
import ar.com.mercadolibre.joyas.model.dto.request.CreateJewelryDTO;
import ar.com.mercadolibre.joyas.model.dto.request.UpdateJewelryDTO;
import ar.com.mercadolibre.joyas.service.IJewelryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelryController {

    private final IJewelryService service;

    public JewelryController(IJewelryService service){
        this.service = service;
    }


    @PostMapping("/new")
    public ResponseEntity<Long> createJewelry(@RequestBody CreateJewelryDTO jewelryDTO){
        Long response = service.createJewelry(jewelryDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Jewelry>> getAllJewelry(){
        List<Jewelry> response = service.getAllJewelry();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJewelry(@PathVariable Long id){
        service.deleteJewelry(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jewelry> updateJewelry(@PathVariable Long id,
                                                 @RequestBody UpdateJewelryDTO dto){
        return ResponseEntity.ok(service.updateJewelry(id, dto));
    }
}
