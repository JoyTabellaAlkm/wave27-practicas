package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.PrendaRequestDTO;
import com.mercadolibre.showroom.dto.PrendaResponseDTO;
import com.mercadolibre.showroom.dto.VentaRequestDTO;
import com.mercadolibre.showroom.service.venta.IVentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sale")
public class VentaController {

    @Autowired
    IVentaService ventaService;

    @GetMapping()
    public ResponseEntity<?> obtenerTodasLasVentas(){
    return  new ResponseEntity<>(ventaService.obtenerVentas(), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> devolverUnaVentaEnParticular (@PathVariable Long number) {
        return new ResponseEntity<>(ventaService.getVentaByID(number),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> agregarVenta(@RequestBody VentaRequestDTO ventaRequestDTO){
        return new ResponseEntity<>(ventaService.agregarVenta(ventaRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{number}")
    public ResponseEntity<?> actualizarVenta(@PathVariable Long number, @RequestBody @Valid VentaRequestDTO ventaRequestDTO){
        return new ResponseEntity<>(ventaService.actualizarVenta(number,ventaRequestDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVenta(@PathVariable Long id){
        return new ResponseEntity<>(ventaService.eliminarVenta(id),HttpStatus.OK);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> devolverListaDePrendasByVenta(@PathVariable Long number) {
        List<PrendaResponseDTO> prendas = ventaService.getPrendasByVenta(number);
        return new ResponseEntity<>(prendas,HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<?> devolverPrendasPorFecha (@RequestParam String fecha) {
        return new ResponseEntity<>(ventaService.devolverPrendasPorFecha(fecha),HttpStatus.OK);
    }

}
