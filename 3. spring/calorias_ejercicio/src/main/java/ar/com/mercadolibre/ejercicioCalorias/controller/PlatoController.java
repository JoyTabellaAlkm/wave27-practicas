package ar.com.mercadolibre.ejercicioCalorias.controller;

import ar.com.mercadolibre.ejercicioCalorias.dto.getCaloriesDTO;
import ar.com.mercadolibre.ejercicioCalorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PlatoController {

    @Autowired
    private final IPlatoService iPlatoService;

    public PlatoController(IPlatoService iPlatoService){
        this.iPlatoService = iPlatoService;
    }

    @PostMapping("/calories/{namePlato}")
    public ResponseEntity<?> getCaloriasPlato(@RequestBody getCaloriesDTO dto){
        return new ResponseEntity<>(iPlatoService.getCaloriasPlato(dto), HttpStatus.OK);
    }

    @GetMapping("/lista/{namePlato}")
    public ResponseEntity<?> getListaIngredientesPlato(@PathVariable String namePlato){
        return new ResponseEntity<>(iPlatoService.getListaIngredientesPlato(namePlato), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getIngredienteMas(){
        return new ResponseEntity<>(iPlatoService.getIngredienteMasCaloria(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPlatos(){
        return new ResponseEntity<>(iPlatoService.getAllPlatos(),HttpStatus.OK);
    }
}
