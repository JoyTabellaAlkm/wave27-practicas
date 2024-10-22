package com.example.segurovehiculos.controller;

import com.example.segurovehiculos.service.IVehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/patentes")
    ResponseEntity<?> getPatentes() {
        return ResponseEntity.ok(vehiculoService.getPatentes());
    }

    @GetMapping("/patente-marca")
    ResponseEntity<?> getPatenteMarca() {
        return ResponseEntity.ok(vehiculoService.getPatenteMarcaPorAnio());
    }

    @GetMapping("/patentes-muchas-ruedas")
    ResponseEntity<?> getPatentesMuchasRuedas() {
        return ResponseEntity.ok(vehiculoService.getPatentesMuchasRuedas());
    }

    @GetMapping("/siniestro-mayor-10000")
    ResponseEntity<?> getSiniestroMayor10000() {
        return ResponseEntity.ok(vehiculoService.getSiniestroMayor10000());
    }

    @GetMapping("/suma-perdida")
    ResponseEntity<?> getSumaPerdida() {
        return ResponseEntity.ok(vehiculoService.getSumaPerdida());
    }
}
