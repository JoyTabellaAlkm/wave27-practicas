package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.request.VehicleUpdateDTO;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> saveVehicle(@RequestBody Vehicle vehicle){
        vehicleService.saveVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> getVehicleByColorAndYear(@PathVariable String color,
                                                      @PathVariable Integer year){
        return new ResponseEntity<>(vehicleService.getVehicleByColorAndYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> getVehicleByBrandAndYears(@PathVariable String brand,
                                                       @PathVariable (name = "start_year") Integer startYear,
                                                       @PathVariable (name = "end_year") Integer endYear){
        return new ResponseEntity<>(vehicleService.getVehicleByBrandAndYears(brand, startYear, endYear), HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageSpeedByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getAverageSpeedByBrand(brand), HttpStatus.OK);
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable Long id,
                                         @RequestBody VehicleUpdateDTO vehicleUpdateDTO){
        vehicleService.updateVehicleSpeed(id, vehicleUpdateDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> getVehicleByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.getVehicleByFuel(type), HttpStatus.OK);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> updateFuel(@PathVariable Long id,
                                        @RequestBody VehicleUpdateDTO vehicle){
        vehicleService.updateFuel(id, vehicle);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> getBrandAverageCapacity(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getBrandAveragePassangers(brand), HttpStatus.OK);
    }

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> getVehicleByDimensions(@RequestParam (required = false) String length,
                                                    @RequestParam (required = false) String width){
        return new ResponseEntity<>(vehicleService.getVehiclesByDimension(length, width), HttpStatus.OK);
    }

    @GetMapping("/vehicles/weight")
    public ResponseEntity<?> getVehiclesByWeight(@RequestParam (required = false, name = "weight_min") Integer weightMin,
                                                 @RequestParam (required = false, name = "weight_max") Integer weightMax){
        return new ResponseEntity<>(vehicleService.getVehiclesByWeight(weightMin, weightMax), HttpStatus.OK);
    }

}
