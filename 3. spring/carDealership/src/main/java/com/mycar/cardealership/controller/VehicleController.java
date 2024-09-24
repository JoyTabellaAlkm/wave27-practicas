package com.mycar.cardealership.controller;

import com.mycar.cardealership.dto.CarCreationDto;
import com.mycar.cardealership.dto.CarDto;
import com.mycar.cardealership.entity.ServiceEntity;
import com.mycar.cardealership.service.ICarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleController {

    private ICarService carService;

    public VehicleController(ICarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(carService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CarCreationDto carCreationDto) {
        return new ResponseEntity<>(carService.create(carCreationDto), HttpStatus.CREATED);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getCarsByDate(@RequestParam String since, @RequestParam String to) {
        return new ResponseEntity<>(carService.findCarsByDate(since, to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getPricesByDate(@RequestParam String since, @RequestParam String to) {
        return new ResponseEntity<>(carService.findCarsByPrice(since, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
        return new ResponseEntity<>(carService.findById(id), HttpStatus.OK);
    }

}
