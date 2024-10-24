package ar.org.mercadolibre.showroom.controller;

import ar.org.mercadolibre.showroom.dto.SaleDTO;
import ar.org.mercadolibre.showroom.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class SalesController {

    @Autowired
    ISaleService saleService;

    //Crear una nueva venta.
    @PostMapping("/sale")
    public ResponseEntity<?> createSale(@RequestBody SaleDTO saleDTO){
        return new ResponseEntity<>(saleService.createSale(saleDTO), HttpStatus.OK);
    }

    //Devolver todas las ventas
    //Traer todas las prendas de una determinada fecha
    @GetMapping("/sale")
    public ResponseEntity<?> getAllSales(){
        return new ResponseEntity<>(saleService.getAllSales(), HttpStatus.OK);
    }

    //Devolver una venta en particular
    @GetMapping("/sale/{number}")
    public ResponseEntity<?> getSaleByNumber(@PathVariable Long number){
        return new ResponseEntity<>(saleService.getSaleByNumber(number), HttpStatus.OK);
    }

    //ctualizar una venta en particular
    @PutMapping("/sale/{number}")
    public ResponseEntity<?> updateSaleByNumber(@PathVariable Long number, @RequestBody SaleDTO saleDTO){
        return new ResponseEntity<>(saleService.updateSaleByNumber(number, saleDTO), HttpStatus.OK);
    }

    //Eliminar una venta en particular
    @DeleteMapping("/sale/{number}")
    public ResponseEntity<?> deleteSale(@PathVariable Long number){
        return new ResponseEntity<>(saleService.deleteSale(number), HttpStatus.OK);
    }

}
