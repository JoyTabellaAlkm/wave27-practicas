package ar.com.mercadolibre.showroomelastic.controller;

import ar.com.mercadolibre.showroomelastic.dto.VentaDTO;
import ar.com.mercadolibre.showroomelastic.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/sale")
public class VentaController {

    @Autowired
    IVentaService ventaService;

    @PostMapping
    public ResponseEntity<?> createVenta(@RequestBody VentaDTO ventaDTO){
        return new ResponseEntity<>(ventaService.createVenta(ventaDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllVentas(){
        return new ResponseEntity<>(ventaService.getAllVentas(), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> getVenta(@PathVariable Long number){
        return new ResponseEntity<>(ventaService.getVenta(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<?> updatePrenda(@PathVariable Long number, @RequestBody VentaDTO ventaDTO){
        return new ResponseEntity<>(ventaService.updateVenta(number, ventaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> deletePrenda(@PathVariable Long number){
        return new ResponseEntity<>(ventaService.deleteVenta(number), HttpStatus.OK);
    }

    @GetMapping("/fecha")
    public ResponseEntity<?> getAllPrendasByDate(@RequestParam LocalDate date){
        return new ResponseEntity<>(ventaService.getAllVentasByDate(date), HttpStatus.OK);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> getAllVentasByPrendas(@PathVariable Long number){
        return new ResponseEntity<>(ventaService.getAllVentasByPrendas(number), HttpStatus.OK);
    }

}
