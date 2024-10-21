package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dto.CreateJewelDto;
import com.bootcamp.joyeria.dto.CreatedJewelDto;
import com.bootcamp.joyeria.dto.JewelDto;
import com.bootcamp.joyeria.service.IJewelryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelryController {
    private final IJewelryService jewelryService;

    public JewelryController(IJewelryService jewelryService) {
        this.jewelryService = jewelryService;
    }

    @PostMapping("/new")
    public ResponseEntity<CreatedJewelDto> createJewel(@RequestBody CreateJewelDto createJewelDto) {
        CreatedJewelDto createdJewel = jewelryService.createJewel(createJewelDto);
        return ResponseEntity.ok(createdJewel);
    }

    @GetMapping
    public ResponseEntity<List<JewelDto>> getJewelry() {
        List<JewelDto> jewelry = jewelryService.getJewelry();
        return ResponseEntity.ok(jewelry);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJewel(@PathVariable Long id) {
        jewelryService.deleteJewel(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<JewelDto> updateJewel(@PathVariable(name = "id_modificar") Long id, @RequestBody CreateJewelDto createJewelDto) {
        JewelDto updatedJewel = jewelryService.updateJewel(id, createJewelDto);
        return ResponseEntity.ok(updatedJewel);
    }

}
