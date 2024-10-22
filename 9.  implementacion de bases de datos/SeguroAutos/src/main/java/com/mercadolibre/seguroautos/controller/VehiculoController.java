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

    //0
    @PostMapping()
    public ResponseEntity<?> agregarVehiculo(@RequestBody VehiculoDTO vehiculoDTO){
        return new ResponseEntity<>(vehiculoService.agregarVehiculo(vehiculoDTO), HttpStatus.CREATED);
    }

    //1
    @GetMapping("/patente")
    public ResponseEntity<?> obtenerPorTodasPatentes(){
        return new ResponseEntity<>( vehiculoService.obtenerTodasPatentes(), HttpStatus.OK);
    }

    //2
    @GetMapping("/patente_marca")
    public ResponseEntity<?> obtenerPorPatenteYMarca(){
        return new ResponseEntity<>( vehiculoService.obtenerPorPatenteYMarca(), HttpStatus.OK);
    }

    //3
    @GetMapping("/fabricacion_ruedas")
    public ResponseEntity<?> obtenerPorAnioFabricacionAndCantidadRuegas(){
        return new ResponseEntity<>( vehiculoService.obtenerPorCantidadDeRuedasAndCantidadRuedas(), HttpStatus.OK );
    }

    //4
    @GetMapping("/siniestros_mayores")
    public ResponseEntity<?> listarSiniestrosMayores(){
        return new ResponseEntity<>( vehiculoService.listarSiniestrosMayores(), HttpStatus.OK );
    }

    //5
    @GetMapping("/siniestros_mayores_total")
    public ResponseEntity<?> listarSiniestrosMayoresTotal(){
        return new ResponseEntity<>( vehiculoService.listarSiniestrosMayoresTotal(), HttpStatus.OK );
    }

}
