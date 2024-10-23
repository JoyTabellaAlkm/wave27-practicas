package com.mercadolibre.seguroautos.controller;

import com.mercadolibre.seguroautos.dto.SiniestroDTO;
import com.mercadolibre.seguroautos.dto.VehiculoDTO;
import com.mercadolibre.seguroautos.service.ISiniestroService;
import com.mercadolibre.seguroautos.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/siniestro")
public class SiniestroController {

    @Autowired
    ISiniestroService siniestroService;

    @PostMapping()
    public ResponseEntity<?> agregarVehiculo(@RequestBody SiniestroDTO siniestroDTO){
        return new ResponseEntity<>(siniestroService.agregarSiniestro(siniestroDTO), HttpStatus.CREATED);
    }
}
