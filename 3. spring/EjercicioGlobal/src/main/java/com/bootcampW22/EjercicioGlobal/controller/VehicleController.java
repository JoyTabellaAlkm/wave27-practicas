package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping()
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDto vehicleDto) {
        return new ResponseEntity<>(vehicleService.saveVehicle(vehicleDto), HttpStatus.CREATED);
    }

    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<?> getVehiclesByColorAndYear(@PathVariable String color, @PathVariable int year) {
        return new ResponseEntity<>(vehicleService.findByColorAndYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageBrandSpeed(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.findAverageSpeed(brand), HttpStatus.OK);
    }

    @PostMapping("/batch")
    public ResponseEntity<?> createVehiclesBatch(@RequestBody List<VehicleDto> vehicles) {
        return new ResponseEntity<>(vehicleService.saveVehicles(vehicles), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update_speed")
    public ResponseEntity<?> updateMaxSpeed(@PathVariable Long id, @RequestBody String maxSpeed) {
        return new ResponseEntity<>(vehicleService.updateMaxSpeed(id, maxSpeed), HttpStatus.OK);
    }

    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<?> getVehiclesByFuelType(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.findVehiclesByFuelType(type), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicleById(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.deleteVehicleById(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/transmission/{type}")
    public ResponseEntity<?> getVehiclesByTransmission(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.findByTransmission(type), HttpStatus.OK);
    }

    @PatchMapping("/{id}/update_fuel")
    public ResponseEntity<?> updateFuel(@PathVariable Long id, @RequestBody String type) {
        return new ResponseEntity<>(vehicleService.updateFuel(id, type), HttpStatus.OK);
    }

    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAverageCapacityByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.calculateCapacityByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/dimensions")
    public ResponseEntity<?> getVehiclesByDimensions(@RequestParam String length, @RequestParam String width) {
        return new ResponseEntity<>(vehicleService.findVehiclesByDimensions(length, width), HttpStatus.OK);
    }

    @GetMapping("/weight")
    public ResponseEntity<?> getVehicleByWeigth(@RequestParam String min, @RequestParam String max) {
        return new ResponseEntity<>(vehicleService.findVehiclesByWeigth(min, max), HttpStatus.OK);
    }
}
