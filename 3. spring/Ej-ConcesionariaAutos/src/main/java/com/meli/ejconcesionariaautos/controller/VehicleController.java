package com.meli.ejconcesionariaautos.controller;

import com.meli.ejconcesionariaautos.dto.request.VehicleDto;
import com.meli.ejconcesionariaautos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    @Autowired
    IVehicleService vehicleService;

    @PostMapping("/add")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto newVehicle){
        return new ResponseEntity<>(vehicleService.addVehicle(newVehicle), HttpStatus.OK);
    }

    @GetMapping("/show")
    public ResponseEntity<?> showAllVehicles(){
        return new ResponseEntity<>(vehicleService.showAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> listVehiclesByDate(@RequestParam LocalDate since, @RequestParam LocalDate to){
        return new ResponseEntity<>(vehicleService.listVehiclesByDate(since, to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> listVehiclesByPrice(@RequestParam int since, @RequestParam int to){
        return new ResponseEntity<>(vehicleService.listVehiclesByPrice(since, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> vehicleById(@PathVariable int id){
        return new ResponseEntity<>(vehicleService.showVehicleById(id), HttpStatus.OK);
    }
}
