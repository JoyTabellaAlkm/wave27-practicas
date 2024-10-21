package ar.com.mercadolibre.clavescompuestas.controller;

import ar.com.mercadolibre.clavescompuestas.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CompraController {

    @Autowired
    private ICompraService compraService;

    @GetMapping("/compra-item")
    public ResponseEntity<?> getAllCompraItem(){
        return new ResponseEntity<>(compraService.getAllCompraItem(), HttpStatus.OK);
    }

}
