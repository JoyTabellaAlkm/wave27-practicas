package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto) {
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleDto), HttpStatus.OK);
    }

    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<?> getByColorYear(@PathVariable String color, @PathVariable Integer year) {
        return new ResponseEntity<>(vehicleService.searchByColorYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> getByBrandYear(@PathVariable String brand, @PathVariable("start_year") Integer startYear, @PathVariable("end_year") Integer endYear) {
        return new ResponseEntity<>(vehicleService.searchByBrandYear(brand, startYear, endYear), HttpStatus.OK);
    }

    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.getAverageByBrand(brand), HttpStatus.OK);
    }

    @PostMapping("/batch")
    public ResponseEntity<?> addMultipleVehicles(@RequestBody List<VehicleDto> listVehicleDto) {
        return new ResponseEntity<>(vehicleService.addMultipleVehicles(listVehicleDto), HttpStatus.OK);
    }

    @PutMapping("/{id}/update_speed")
    public ResponseEntity<?> editSpeed(@PathVariable("id") Long id, @RequestParam Double speed) {
        return new ResponseEntity<>(vehicleService.editSpeed(id, speed), HttpStatus.OK);
    }

    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<?> getVehiclesByFuel(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.getVehiclesByFuel(type), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/transmission/{type}")
    public ResponseEntity<?> getVehiclesByTransmission(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.getVehiclesByTransmission(type), HttpStatus.OK);
    }

    @PutMapping("/{id}/update_fuel")
    public ResponseEntity<?> editFuel(@PathVariable("id") Long id, @RequestParam String fuel) {
        return new ResponseEntity<>(vehicleService.editFuel(id, fuel), HttpStatus.OK);
    }

    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAverageCapacityByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.getAverageCapacityByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/dimensions")
    public ResponseEntity<?> getVehiclesByDimension(@RequestParam String lengthValue, @RequestParam String widthValue) {
        return new ResponseEntity<>(vehicleService.getVehiclesByDimension(lengthValue, widthValue), HttpStatus.OK);
    }

    @GetMapping("/weight")
    public ResponseEntity<?> getByRangeWeight(@RequestParam("min") Double weightMin, @RequestParam("max") Double weightMax) {
        return new ResponseEntity<>(vehicleService.getByRangeWeight(weightMin, weightMax), HttpStatus.OK);
    }

}
