package ar.com.mercadolibre.seguros.controller;


import ar.com.mercadolibre.seguros.model.Vehicle;
import ar.com.mercadolibre.seguros.model.dto.request.VehicleRequestDTO;
import ar.com.mercadolibre.seguros.model.dto.response.VehicleLicensePlateBrandResponseDTO;
import ar.com.mercadolibre.seguros.model.dto.response.VehiclePlateBrandModelResponseDTO;
import ar.com.mercadolibre.seguros.model.dto.response.VehicleResponseDTO;
import ar.com.mercadolibre.seguros.service.IVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final IVehicleService service;

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> createVehicle(@RequestBody VehicleRequestDTO vehicle) {
        VehicleResponseDTO createdVehicle = service.createVehicle(vehicle);
        return ResponseEntity.ok(createdVehicle);
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehicles() {
        List<VehicleResponseDTO> vehicles = service.getAll();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/plates")
    public ResponseEntity<List<String>> getAllLicensePlates() {
        List<String> response = service.getAllLicensePlates();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<VehicleLicensePlateBrandResponseDTO>> getVehiclesSortedByYear() {
        List<VehicleLicensePlateBrandResponseDTO> vehicles = service.getVehicleSortedByYear();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/wheels")
    public ResponseEntity<List<String>> getPlatesByWheelsAndYear() {
        List<String> vehicles = service.getPlatesWheelsAndYear();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/claim/{amount}")
    public ResponseEntity<List<VehiclePlateBrandModelResponseDTO>> getVehiclesSortedByYear(@PathVariable Double amount) {
        List<VehiclePlateBrandModelResponseDTO> vehicles = service.getPlateBrandModelByAmountClaim(amount);
        return ResponseEntity.ok(vehicles);
    }
}
