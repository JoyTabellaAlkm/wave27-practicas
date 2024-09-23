package ar.com.mercadolibre.ejercicioCalorias.controller;

import ar.com.mercadolibre.ejercicioCalorias.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlatoController {

    private final IService iService;
    @Autowired
    public PlatoController(IService iService){
        this.iService = iService;
    }
    @GetMapping("/calories/{namePlato}")
    public ResponseEntity<?> getCaloriasPlato(@PathVariable String namePlato){
        return new ResponseEntity<>(iService.getCaloriasPlato(namePlato), HttpStatus.OK);
    }

    @GetMapping("/lista/{namePlato}")
    public ResponseEntity<?> getListaIngredientesPlato(@PathVariable String namePlato){
        return new ResponseEntity<>(iService.getListaIngredientesPlato(namePlato), HttpStatus.OK);
    }

    @GetMapping("/ingrediente/{name}")
    public ResponseEntity<?> getIngredienteMas(@PathVariable String name){
        return new ResponseEntity<>(iService.getIngredienteMasCaloria(name), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPlatos(){
        return new ResponseEntity<>(iService.getAllPlatos(),HttpStatus.OK);
    }
}
