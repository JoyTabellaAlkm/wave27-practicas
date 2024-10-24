package ar.com.mercadolibre.showroomelastic.controller;

import ar.com.mercadolibre.showroomelastic.dto.PrendaDTO;
import ar.com.mercadolibre.showroomelastic.service.IPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PrendaController {

   @Autowired
   IPrendaService prendaService;

   @PostMapping("/clothes")
    public ResponseEntity<?> createPrendas(@RequestBody PrendaDTO prendaDTO){
       return new ResponseEntity<>(prendaService.createPrenda(prendaDTO), HttpStatus.CREATED);
   }

   @GetMapping("/clothes")
   public ResponseEntity<?> getAllPrendas(){
      return new ResponseEntity<>(prendaService.getAllPrendas(), HttpStatus.OK);
   }

   @GetMapping("/clothes/{code}")
   public ResponseEntity<?> getPrenda(@PathVariable Long code){
      return new ResponseEntity<>(prendaService.getPrenda(code), HttpStatus.OK);
   }

   @PutMapping("/clothes/{code}")
   public ResponseEntity<?> updatePrenda(@PathVariable Long code, @RequestBody PrendaDTO prendaDTO){
      return new ResponseEntity<>(prendaService.updatePrenda(code, prendaDTO), HttpStatus.OK);
   }

   @DeleteMapping("/clothes/{code}")
   public ResponseEntity<?> deletePrenda(@PathVariable Long code){
      return new ResponseEntity<>(prendaService.deletePrenda(code), HttpStatus.OK);
   }

   @GetMapping("/clothes-size/{size}")
   public ResponseEntity<?> getAllPrendasBySize(@PathVariable String size){
      return new ResponseEntity<>(prendaService.getAllPrendasBySize(size), HttpStatus.OK);
   }

   @GetMapping("/clothes-name")
   public ResponseEntity<?> getAllPrendasByName(@RequestParam String name){
      return new ResponseEntity<>(prendaService.getAllPrendasByName(name), HttpStatus.OK);
   }
}
