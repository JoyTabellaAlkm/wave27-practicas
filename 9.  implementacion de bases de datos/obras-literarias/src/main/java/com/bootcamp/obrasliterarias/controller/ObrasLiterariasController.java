package com.bootcamp.obrasliterarias.controller;

import com.bootcamp.obrasliterarias.dto.CreateObraLiterariaDto;
import com.bootcamp.obrasliterarias.service.IObraLiterariaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obras-literarias")
public class ObrasLiterariasController {
    private final IObraLiterariaService obraLiterariaService;

    public ObrasLiterariasController(IObraLiterariaService obraLiterariaService) {
        this.obraLiterariaService = obraLiterariaService;
    }

    @PostMapping
    public ResponseEntity<?> createObraLiteraria(@RequestBody CreateObraLiterariaDto createObraLiterariaDto) {
        String id = obraLiterariaService.createObraLiteraria(createObraLiterariaDto);
        return ResponseEntity.ok(id);
    }

    // Retornar las obras de un determinado autor. Por ejemplo, todas las obras de “Garcia Marquez”
    @GetMapping
    public ResponseEntity<?> getObrasLiterarias(@RequestParam(required = false) String autor) {
        return ResponseEntity.ok(obraLiterariaService.getObrasLiterarias(autor));
    }

    // Retornar las obras que contengan palabras claves en sus títulos. Por ejemplo: que contengan la palabra “quijote”
    @GetMapping("/search")
    public ResponseEntity<?> searchObrasLiterarias(@RequestParam(name = "palabra_clave") String palabraClave) {
        return ResponseEntity.ok(obraLiterariaService.searchObrasLiterarias(palabraClave));
    }

    // Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    @GetMapping("/top5")
    public ResponseEntity<?> getTop5ObrasLiterarias() {
        return ResponseEntity.ok(obraLiterariaService.getTop5ObrasLiterarias());
    }

    // Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    @GetMapping("/before/{year}")
    public ResponseEntity<?> getObrasLiterariasBeforeYear(@PathVariable int year) {
        return ResponseEntity.ok(obraLiterariaService.getObrasLiterariasBeforeYear(year));
    }

    // Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”
    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> getObrasLiterariasByEditorial(@PathVariable String editorial) {
        return ResponseEntity.ok(obraLiterariaService.getObrasLiterariasByEditorial(editorial));
    }
}
