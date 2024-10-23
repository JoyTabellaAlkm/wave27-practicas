package com.mercadolibre.seguroautos.controller;

import com.mercadolibre.seguroautos.dto.VehiculoDTO;
import com.mercadolibre.seguroautos.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    IVehiculoService vehiculoService;

    @PostMapping()
    public ResponseEntity<?> agregarVehiculo(@RequestBody VehiculoDTO vehiculoDTO){
        return new ResponseEntity<>(vehiculoService.agregarVehiculo(vehiculoDTO), HttpStatus.CREATED);
    }

    @GetMapping("/patente")
    public ResponseEntity<?> obtenerPorTodasPatentes(){
        return new ResponseEntity<>( vehiculoService.obtenerTodasPatentes(), HttpStatus.OK);
    }

    @GetMapping("/patente_marca")
    public ResponseEntity<?> obtenerPorPatenteYMarca(){
        return new ResponseEntity<>( vehiculoService.obtenerPorPatenteYMarca(), HttpStatus.OK);
    }

    @GetMapping("/ruedas_anio")
    public ResponseEntity<?> obtenerPatentesVehiculosPorRuedasYAnio(){
        return new ResponseEntity<>( vehiculoService.obtenerPatentesVehiculosPorRuedasYAnio(), HttpStatus.OK);
    }
    @GetMapping("/siniestro_mayor")
    public ResponseEntity<?> obtenerVehiculosConSiniestroMayorA10000(){
        return new ResponseEntity<>( vehiculoService.obtenerVehiculosConSiniestroMayorA10000(), HttpStatus.OK);
    }

    @GetMapping("/siniestro_mayor_perdida")
    public ResponseEntity<?> obtenerVehiculosConSiniestroMayorA10000ConSumaPerdida(){
        return new ResponseEntity<>( vehiculoService.obtenerVehiculosConSiniestroMayorA10000ConSumaPerdida(), HttpStatus.OK);
    }

}
