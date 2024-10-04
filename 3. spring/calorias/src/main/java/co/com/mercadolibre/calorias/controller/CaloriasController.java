package co.com.mercadolibre.calorias.controller;

import co.com.mercadolibre.calorias.services.ICaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.EntityReference;

@RestController
@RequestMapping("/api")
public class CaloriasController {

    @Autowired
    ICaloriasService iCaloriasService;

    //a) calcular calorias
    //calcular calorias
    @GetMapping("/calcularCalorias/{name}")
    public ResponseEntity<?> calcularCalorias(@PathVariable String name){
        return new ResponseEntity<>(iCaloriasService.calcularCalorias(name), HttpStatus.OK);
    }
    //b) listar por plato
    @GetMapping("/listaIngredientes/{name}")
    public ResponseEntity<?> listaIngredientes(@PathVariable String name){
        return new ResponseEntity<>(iCaloriasService.listaIngredientes(name), HttpStatus.OK);
    }
}
