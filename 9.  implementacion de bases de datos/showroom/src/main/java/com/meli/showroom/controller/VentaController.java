package com.meli.showroom.controller;

import com.meli.showroom.dto.VentaRequestDto;
import com.meli.showroom.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sale")
public class VentaController {
    @Autowired
    IVentaService ventaService;

    @PostMapping
    public ResponseEntity<?> nuevaVenta(@RequestBody VentaRequestDto venta){
        return new ResponseEntity<>(ventaService.nuevaVenta(venta), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listarVentas(@RequestParam(required = false) String date){
        return new ResponseEntity<>(ventaService.listarVentas(date), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> devolverVenta(@PathVariable Integer number){
        return new ResponseEntity<>(ventaService.devolverVenta(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<?> actualizarVenta(@PathVariable Integer number, @RequestBody VentaRequestDto venta){
        return new ResponseEntity<>(ventaService.actualizarVenta(number, venta), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> eliminarVenta(@PathVariable Integer number){
        return new ResponseEntity<>(ventaService.eliminarVenta(number), HttpStatus.OK);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> listarPrendasVenta(@PathVariable Integer number){
        return new ResponseEntity<>(ventaService.listarPrendasVenta(number), HttpStatus.OK);
    }


}
