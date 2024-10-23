package com.mercadolibre.productos.controller;


import com.mercadolibre.productos.dto.request.ProductoRequestDto;
import com.mercadolibre.productos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService service;

    @PostMapping("/crear")
    public ResponseEntity<?> createProducto(@RequestBody ProductoRequestDto productoRequestDto){
        return new ResponseEntity<>(service.createProducto(productoRequestDto), HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable String id, @RequestBody ProductoRequestDto productoRequestDto){
        return new ResponseEntity<>(service.updateProducto(id,productoRequestDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getAllProductos(){
        return new ResponseEntity<>(service.getAllProductos(), HttpStatus.OK);
    }

}
