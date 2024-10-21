package com.meli.compraclavecomp.controller;

import com.meli.compraclavecomp.dto.CompraDto;
import com.meli.compraclavecomp.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CompraController {
    @Autowired
    ICompraService compraService;

    @PostMapping("/nuevaCompra")
    public ResponseEntity<?> nuevaCompra(@RequestBody CompraDto nuevaCompra){
        return new ResponseEntity<>(compraService.crearCompra(nuevaCompra), HttpStatus.OK);
    }
}
