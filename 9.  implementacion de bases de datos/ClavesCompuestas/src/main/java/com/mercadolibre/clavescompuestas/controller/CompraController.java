package com.mercadolibre.clavescompuestas.controller;

import com.mercadolibre.clavescompuestas.dto.request.CompraRequestDto;
import com.mercadolibre.clavescompuestas.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {
    @Autowired
    ICompraService service;

    @PostMapping
    public ResponseEntity<?> createCompra( @RequestBody CompraRequestDto compraRequestDto){
    return new ResponseEntity<>(service.createCompra(compraRequestDto), HttpStatus.CREATED);

    }
}
