package com.mercadolibre.obrasliterariaselasticsearch.controller;

import com.mercadolibre.obrasliterariaselasticsearch.dto.ObraLiterariaRequestDTO;
import com.mercadolibre.obrasliterariaselasticsearch.service.IObrasLiterariasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obras-literarias")
public class ObrasLiterariasController {

    @Autowired
    private IObrasLiterariasService obrasLiterariasService;

    @PostMapping
    public ResponseEntity<?> saveObraLiteraria(@RequestBody ObraLiterariaRequestDTO obraLiterariaRequestDTO) {
        return ResponseEntity.ok(obrasLiterariasService.saveObraLiteraria(obraLiterariaRequestDTO));
    }

    @GetMapping("/autor")
    public ResponseEntity<?> getObrasLiterariasByAutor(@RequestParam String autor) {
        return ResponseEntity.ok(obrasLiterariasService.getObrasLiterariasByAutor(autor));
    }

    @GetMapping("/title")
    public ResponseEntity<?> getObrasLiterariasByTitle(@RequestParam String title) {
        return ResponseEntity.ok(obrasLiterariasService.getObrasLiterariasByTitle(title));
    }

    @GetMapping("/top5-pages")
    public ResponseEntity<?> getTop5ObrasLiterariasByPages() {
        return ResponseEntity.ok(obrasLiterariasService.getTop5ObrasLiterariasByPages());
    }

    @GetMapping("/after-year/{year}")
    public ResponseEntity<?> getObrasLiterariasAfterYear(@PathVariable Integer year) {
        return ResponseEntity.ok(obrasLiterariasService.getObrasLiterariasAfterYear(year));
    }

    @GetMapping("/editorial")
    public ResponseEntity<?> getObrasLiterariasByEditorial(@RequestParam String editorial) {
        return ResponseEntity.ok(obrasLiterariasService.getObrasLiterariasByEditorial(editorial));
    }
}
