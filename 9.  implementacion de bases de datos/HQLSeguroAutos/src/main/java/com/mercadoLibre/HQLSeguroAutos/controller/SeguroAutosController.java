package com.mercadoLibre.HQLSeguroAutos.controller;

import com.mercadoLibre.HQLSeguroAutos.dto.SiniestroRequestDTO;
import com.mercadoLibre.HQLSeguroAutos.dto.VehiculoRequestDTO;
import com.mercadoLibre.HQLSeguroAutos.service.ISeguroAutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seguro-autos")
public class SeguroAutosController {

    @Autowired
    private ISeguroAutosService seguroAutosService;

    @PostMapping("/save-vehiculo")
    public ResponseEntity<?> saveVehiculo(@RequestBody VehiculoRequestDTO vehiculo) {
        return ResponseEntity.ok(seguroAutosService.saveVehiculo(vehiculo));
    }

    @PostMapping("/denunciar-siniestro")
    public ResponseEntity<?> denunciarSiniestro(@RequestBody SiniestroRequestDTO siniestro) {
        return ResponseEntity.ok(seguroAutosService.denunciarSiniestro(siniestro));
    }

    @GetMapping("/get-all-patentes")
    public ResponseEntity<?> getAllPatentes() {
        return ResponseEntity.ok(seguroAutosService.getAllPatentes());
    }

    @GetMapping("/get-patentes-by-ruedas-and-anio")
    public ResponseEntity<?> getPatentesByRuedasAndAnio() {
        return ResponseEntity.ok(seguroAutosService.getPatentesByRuedasAndAnio());
    }

    @GetMapping("/get-info-by-perdida")
    public ResponseEntity<?> getPatenteMarcaModeloByPerdida() {
        return ResponseEntity.ok(seguroAutosService.getPatenteMarcaModeloByPerdida());
    }

    @GetMapping("/get-info-and-total-perdida")
    public ResponseEntity<?> getPatenteMarcaModeloAndTotalPerdidaByPerdida() {
        return ResponseEntity.ok(seguroAutosService.getPatenteMarcaModeloAndTotalPerdidaByPerdida());
    }
}
