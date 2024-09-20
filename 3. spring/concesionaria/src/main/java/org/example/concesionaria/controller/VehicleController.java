package org.example.concesionaria.controller;

import jakarta.annotation.PostConstruct;
import org.example.concesionaria.dto.createVehicleDTO;
import org.example.concesionaria.entities.Vehicle;
import org.example.concesionaria.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("v1/api/vehicles")
    public void createVehicle(@RequestBody createVehicleDTO createVehicleDTO) {
        this.vehicleService.createVehicle(createVehicleDTO);
    }

    @GetMapping("v1/api/vehicles")
    public List<Vehicle> getVehicles()
    {
        return this.vehicleService.getVehicles();
    }

    @GetMapping("v1/api/vehicles/dates")
    public List<Vehicle> getVehiclesByDates(@RequestParam Date since, @RequestParam Date to) {
        return this.vehicleService.getVehiclesByDates(since, to);
    }

    @GetMapping("v1/api/vehicles/prices")
    public List<Vehicle> getVehiclesByPrice(@RequestParam Integer since, @RequestParam Integer to){
        return this.vehicleService.getVehiclesByPrice(since, to);
    }

    @GetMapping("v1/api/vehicles/{id}")
    public Vehicle getVehicleById(@PathVariable UUID id) {
        return this.vehicleService.getVehicleById(id);
    }
}
