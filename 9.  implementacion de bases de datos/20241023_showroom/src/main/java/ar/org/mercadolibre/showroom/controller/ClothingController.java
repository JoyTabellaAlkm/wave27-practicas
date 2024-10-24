package ar.org.mercadolibre.showroom.controller;

import ar.org.mercadolibre.showroom.dto.ClothingDTO;
import ar.org.mercadolibre.showroom.service.IClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class ClothingController {

        @Autowired
        IClothingService clothingService;

        @PostMapping("/clothes")
        public ResponseEntity<?> addClouthing(@RequestBody ClothingDTO clothingdto){
            return new ResponseEntity<>(clothingService.addClouthing(clothingdto), HttpStatus.OK);
        }

        @GetMapping("/clothes")
        public ResponseEntity<?> getAllClothes( @RequestParam(required = false) String name){
            return new ResponseEntity<>(clothingService.getAllClothes(null,name),HttpStatus.OK);
        }


        @GetMapping("/clothes/{size}")
        public ResponseEntity<?> getClothesBySizeOrName(@PathVariable String size){
            return new ResponseEntity<>(clothingService.getAllClothes(size, null),HttpStatus.OK);
        }

        @GetMapping("/clothes/code/{code}") //se modifica ruta por inconsistencia con size
        public ResponseEntity<?> getClothingByCode(@PathVariable long code){
            return new ResponseEntity<>(clothingService.getClothingByCode(code),HttpStatus.OK);
        }

        @PutMapping("/clothes/{code}")
        public ResponseEntity<?> updateClothing(@PathVariable long code, @RequestBody ClothingDTO clothingDTO){
            return new ResponseEntity<>(clothingService.updateClothing(code, clothingDTO),HttpStatus.OK);
        }


        @DeleteMapping("/clothes/{code}")
        public ResponseEntity<?> deleteClothing(@PathVariable long code, @RequestBody ClothingDTO clothingDTO){
            return new ResponseEntity<>(clothingService.deleteClothing(code, clothingDTO),HttpStatus.OK);
        }

        //Traer todas las prendas de una determinada fecha
        @GetMapping("/sale/date")
        public ResponseEntity<?>  getAllsClothingBySaleDate(@RequestParam(name = "date", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date) {
            return new ResponseEntity<>(clothingService.getAllsClothingBySaleDate(date), HttpStatus.OK);
        }


        //Traer la lista completa de prendas de una determinada venta.
        @GetMapping("/sale/clothes/{number}")
        public ResponseEntity<?> getClothingsBySaleNumber(@PathVariable Long number) {
            return new ResponseEntity<>(clothingService.getClothingsBySaleNumber(number), HttpStatus.OK);
        }

}
