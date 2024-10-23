package ar.com.mercadolibre.clothes.controller;

import ar.com.mercadolibre.clothes.entity.Sales;
import ar.com.mercadolibre.clothes.service.ISalesService;
import org.apache.coyote.Response;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/sale")
public class SalesController {
    private final ISalesService salesService;

    public SalesController(ISalesService salesService){this.salesService=salesService;}

    @PostMapping
    public ResponseEntity<?> createSale(@RequestBody Sales sale){
        return ResponseEntity.ok(salesService.save(sale));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(salesService.findAll());
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> findSaleById(@PathVariable String number){
        return ResponseEntity.ok(salesService.findSaleById(number));
    }

    @PutMapping("/{number}")
    public ResponseEntity<?> updateSale(@PathVariable String number, @RequestBody Sales sale){
        return ResponseEntity.ok(salesService.updateSale(number, sale));
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> deleteSale(@PathVariable String number){
        return ResponseEntity.ok(salesService.deleteSale(number));
    }

    @GetMapping("/date")
    public ResponseEntity<?> findByDate(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date){
        return ResponseEntity.ok(salesService.findByDate(date));
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> findAllClothes(@PathVariable String number){
        return ResponseEntity.ok(salesService.findAllClothes(number));
    }
}
