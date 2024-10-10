package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles") // Corrección de CodeReview usar RequestMapping
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
    public ResponseEntity<?> addVehicles(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.addVehicles(vehicleDto), HttpStatus.CREATED);
    }

    // Funcionalidad N°2

    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<?> searchByColorAndYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.searchVehicleByColorAndYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> searchByBrandAndYearBetween(@PathVariable String brand, @PathVariable("start_year") int startYear, @PathVariable("end_year") int endYear){
        return new ResponseEntity<>(vehicleService.searchByBrandAndYear(brand, startYear, endYear), HttpStatus.OK);
    }

    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> averageSpeedByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageSpeedByBrand(brand), HttpStatus.OK);
    }

    @PostMapping("/batch")
    public ResponseEntity<?> addVehicles(@RequestBody List<VehicleDto> vehicleDtos){
        return new ResponseEntity<>(vehicleService.addListVehicles(vehicleDtos), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update_speed")
    public ResponseEntity<?> updateVehicle(@PathVariable Long id, @RequestParam Double updateSpeed){
        return new ResponseEntity<>(vehicleService.updateSpeed(id, updateSpeed), HttpStatus.OK);
    }

    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<?> searchByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.searByFuelType(type), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteById(id), HttpStatus.OK);
    }

    @GetMapping("/transmission/{type}")
    public ResponseEntity<?> searchByTransmissionType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.searchByTransmissionType(type), HttpStatus.OK);
    }

    @PutMapping("/{id}/update_fuel")
    public ResponseEntity<?> updateFuelById(@PathVariable Long id, @RequestParam String fuel ){
        return new ResponseEntity<>(vehicleService.updateFuelById(id, fuel), HttpStatus.OK);
    }

    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<?> averageCapacityByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageCapacityByBrand(brand), HttpStatus.OK);
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