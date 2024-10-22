package ar.com.mercadolibre.obras.controller;

import ar.com.mercadolibre.obras.model.Obra;
import ar.com.mercadolibre.obras.service.IObraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obra")
@RequiredArgsConstructor
public class ObraController {

    private final IObraService service;

    @PostMapping
    public ResponseEntity<Obra> save(@RequestBody Obra obra){
        return ResponseEntity.ok(service.save(obra));
    }

    @GetMapping
    public ResponseEntity<List<Obra>> getAll(){
        return ResponseEntity.ok(service.getAllObras());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Obra>> getByName(@PathVariable String name){
        return ResponseEntity.ok(service.getObrasByName(name));
    }

    @GetMapping("/name/fuzzy/{name}")
    public ResponseEntity<List<Obra>> getByNameFuzzy(@PathVariable String name){
        return ResponseEntity.ok(service.getObrasByNameFuzzy(name));
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<Obra>> getObraByAutor(@PathVariable String autor){
        return ResponseEntity.ok(service.getObraByAutor(autor));
    }

    @GetMapping("/top")
    public ResponseEntity<List<Obra>> getTopByPaginas(){
        return ResponseEntity.ok(service.getTopByPaginas());
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Obra>> getByAnioPublicacion(@PathVariable Integer year){
        return ResponseEntity.ok(service.getObrasByAnio(year));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<Obra>> getByEditorial(@PathVariable String editorial){
        return ResponseEntity.ok(service.getByEditorial(editorial));
    }
}
