package ar.com.mercadolibre.empresaseguros.controller;

import ar.com.mercadolibre.empresaseguros.entity.Siniestro;
import ar.com.mercadolibre.empresaseguros.entity.Vehiculo;
import ar.com.mercadolibre.empresaseguros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllVehiculos(){
        return new ResponseEntity<>(vehiculoService.getAllVehiculos(), HttpStatus.OK);
    }

    @PostMapping("/create-vehiculo")
    public ResponseEntity<?> createVehiculo(@RequestBody Vehiculo vehiculo){
        return new ResponseEntity<>(vehiculoService.createVehiculo(vehiculo), HttpStatus.CREATED);
    }

    @PostMapping("/create-siniestro")
    public ResponseEntity<?> createSiniestro(@RequestBody Siniestro siniestro){
        return new ResponseEntity<>(vehiculoService.createSiniestro(siniestro), HttpStatus.CREATED);
    }

    @GetMapping("/patente")
    public ResponseEntity<?> getVehiculoByPatente(){
        return new ResponseEntity<>(vehiculoService.getVehiculoByPatente(), HttpStatus.OK);
    }

    @GetMapping("/patenteAndMarca")
    public ResponseEntity<?> getVehiculoByPatenteAndMarcaOrderByAnioFabricacion(){
        return new ResponseEntity<>(vehiculoService.getVehiculoByPatenteAndMarcaOrderByAnioFabricacion(), HttpStatus.OK);
    }

    @GetMapping("/patenteOrder")
    public ResponseEntity<?> getVehiculoByPatenteAndCantidadRuedasAfterFour(){
        return new ResponseEntity<>(vehiculoService.getVehiculoByPatenteAndCantidadRuedasAfterFour(), HttpStatus.OK);
    }

    @GetMapping("/vehiculo-perdida")
    public ResponseEntity<?> getVehiculoBySiniestro(){
        return new ResponseEntity<>(vehiculoService.getVehiculoBySiniestros(), HttpStatus.OK);
    }

    @GetMapping("/vehiculo-siniestro")
    public ResponseEntity<?> getVehiculoBySiniestroAndPerdida(){
        return new ResponseEntity<>(vehiculoService.getVehiculoBySiniestrosAndPerdida(), HttpStatus.OK);
    }
}
