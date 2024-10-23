package co.mercadolibre.seguros_autos.controller;

import co.mercadolibre.seguros_autos.dto.request.VehiculoRequestDTO;
import co.mercadolibre.seguros_autos.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    IVehiculoService service;

    @PostMapping("/new")
    public ResponseEntity<?> crearVehiculo(@RequestBody VehiculoRequestDTO vehiculoRequestDTO){
        return new ResponseEntity<>(service.crearVehiculo(vehiculoRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ResponseEntity<?> findAllVehiculo(){
        return new ResponseEntity<>(service.findAllVehiculo(), HttpStatus.OK);
    }
    @GetMapping("/list/patente")
    public ResponseEntity<?> findAllPatente(){
        return new ResponseEntity<>(service.findAllPatente(), HttpStatus.OK);
    }
    @GetMapping("/list/PatentesAndMarcaOrderByAnioFabricacion")
    public ResponseEntity<?> findAllPatentesAndMarcaOrderByAnioFabricacion(){
        return new ResponseEntity<>(service.findAllPatentesAndMarcaOrderByAnioFabricacion(), HttpStatus.OK);
    }
    @GetMapping("/list/PatentesByCantidadRuedasAndAnioFabricacionCurrentYear")
    public ResponseEntity<?> findPatentesByCantidadRuedasAndAnioFabricacionCurrentYear(){
        return new ResponseEntity<>(service.findPatentesByCantidadRuedasAndAnioFabricacionCurrentYear(), HttpStatus.OK);
    }
}
