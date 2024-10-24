package ar.com.mercadolibre.clothes.controller;

import ar.com.mercadolibre.clothes.dto.request.SalesRequestDto;
import ar.com.mercadolibre.clothes.service.ISalesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Validated
@RestController
@RequestMapping("/api/sale")
public class SalesController {
    private final ISalesService salesService;

    @Autowired
    public SalesController(ISalesService salesService){this.salesService=salesService;}

    @PostMapping
    public ResponseEntity<?> createSale(@Valid @RequestBody SalesRequestDto sale) {
        return ResponseEntity.ok(salesService.createSales(sale));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(salesService.findAll());
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> findSaleById(@PathVariable Long number) {
        return ResponseEntity.ok(salesService.findSaleById(number));
    }

    @PutMapping("/{number}")
    public ResponseEntity<?> updateSale(@PathVariable Long number, @Valid @RequestBody SalesRequestDto sale) {
        return ResponseEntity.ok(salesService.updateSale(number, sale));
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> deleteSale(@PathVariable Long number) {
        return ResponseEntity.ok(salesService.deleteSale(number));
    }

    @GetMapping("/date")
    public ResponseEntity<?> findByDate(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date) {
        return ResponseEntity.ok(salesService.findByDate(date));
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> findAllClothes(@PathVariable Long number) {
        return ResponseEntity.ok(salesService.findAllClothes(number));
    }
}
