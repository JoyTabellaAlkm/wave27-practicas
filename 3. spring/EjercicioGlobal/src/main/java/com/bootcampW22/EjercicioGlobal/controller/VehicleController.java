package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.request.VehicleBrandDTO;
import com.bootcampW22.EjercicioGlobal.dto.request.VehicleColorYearDTO;
import com.bootcampW22.EjercicioGlobal.dto.request.VehicleSpeedDTO;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    IVehicleService vehicleService;

    //list al vehicles
    @GetMapping()
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    //add a vehicle
    @PostMapping()
    public ResponseEntity<?> newVehicle(@RequestBody VehicleDto vehicleDto) {
        return new ResponseEntity<>(vehicleService.createVehicle(vehicleDto), HttpStatus.CREATED);
    }

    //search vehicles by color and year
    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<?> searchByYearAndColor(@PathVariable String color, @PathVariable int year) {
        return new ResponseEntity<>(vehicleService.searchVehiclesByColorAndYear(new VehicleColorYearDTO(color, year)), HttpStatus.OK);
    }

    //average speed per brand
    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageSpeed(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.calculateAverageSpeed(new VehicleBrandDTO(brand)), HttpStatus.OK);
    }

    //update vehicle max speed
    @PutMapping("/{id}/update_speed")
    public ResponseEntity<?> updateMaxSpeed (@PathVariable Long id, @RequestBody String maxSpeed){
        return new ResponseEntity<>(vehicleService.updateMaxSpeed(new VehicleSpeedDTO(id, maxSpeed)), HttpStatus.OK);
    }


}
