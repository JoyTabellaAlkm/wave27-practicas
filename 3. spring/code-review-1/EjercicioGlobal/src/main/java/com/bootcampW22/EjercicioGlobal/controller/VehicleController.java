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

    @GetMapping
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    // 1. Añadir un vehículo
    @PostMapping
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDto vehicleDto) {
        vehicleService.create(vehicleDto);
        return new ResponseEntity<>("Vehículo creado exitosamente.", HttpStatus.CREATED);
    }

    // 2. Buscar vehículos por color y año
    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<?> getByColorAndYear(@PathVariable String color, @PathVariable Integer year) {
        List<VehicleDto> vehicles = vehicleService.getVehiclesByColorAndYear(color, year);
        return ResponseEntity.ok(vehicles);
    }

    // 3. Buscar vehículos por marca y rango de años (mi code review)
    @GetMapping("/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> getByBrandAndYearRange(@PathVariable String brand, @PathVariable("start_year") Integer startYear, @PathVariable("end_year") Integer endYear) {
        List<VehicleDto> vehicles = vehicleService.getByBrandAndYearRange(brand, startYear, endYear);
        return ResponseEntity.ok(vehicles);
    }

    // 4. Consultar velocidad promedio por marca
    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageSpeed(@PathVariable String brand) {
        return ResponseEntity.ok(vehicleService.getAverageSpeed(brand));
    }

    // 5. Añadir múltiples vehículos
    @PostMapping("/batch")
    public ResponseEntity<?> createVehicle(@RequestBody List<VehicleDto> vehicleDtos) {
        vehicleService.create(vehicleDtos);
        return new ResponseEntity<>("Vehículos creados exitosamente.", HttpStatus.CREATED);
    }

    // 6. Actualizar velocidad máxima de un vehículo
    @PutMapping("/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable Long id, @RequestBody String newSpeed) {
        vehicleService.updateSpeed(id, newSpeed);
        return ResponseEntity.ok("Velocidad del vehículo actualizada exitosamente.");
    }

    // 7. Listar vehículos por tipo de combustible
    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<?> getByFuelType(@PathVariable String type) {
        List<VehicleDto> vehicles = vehicleService.getByFuelType(type);
        return ResponseEntity.ok(vehicles);
    }

    // 8. Eliminar un vehículo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        vehicleService.delete(id);
        return new ResponseEntity<>("Vehículo eliminado exitosamente", HttpStatus.NO_CONTENT);
    }

    // 9. Buscar vehículos por tipo de transmisión
    @GetMapping("/transmission/{type}")
    public ResponseEntity<?> getByTransmission(@PathVariable String type) {
        List<VehicleDto> vehicles = vehicleService.getByTransmission(type);
        return ResponseEntity.ok(vehicles);
    }

    // 10. Actualizar el tipo de combustible de un vehículo
    @PutMapping("/{id}/update_fuel")
    public ResponseEntity<?> updateFuelType(@PathVariable Long id, @RequestBody String newFuelType) {
        vehicleService.updateFuelType(id, newFuelType);
        return ResponseEntity.ok("Tipo de combustible del vehículo actualizado exitosamente.");
    }

    // 11. Obtener la capacidad promedio de personas por marca
    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAverageCapacity(@PathVariable String brand) {
        Double averageCapacity = vehicleService.getAverageCapacity(brand);
        return ResponseEntity.ok(averageCapacity);
    }

    // 12. Buscar vehículos por dimensiones
    @GetMapping("/dimensions")
    public ResponseEntity<?> getByDimensions(@RequestParam String length, @RequestBody String width) {
        List<VehicleDto> vehicles = vehicleService.getByDimensions(length, width);
        return ResponseEntity.ok(vehicles);
    }

    // 13. Listar vehículos por rango de peso
    @GetMapping("/weight")
    public ResponseEntity<?> getByWeightRange(@RequestParam Double min, @RequestParam Double max) {
        List<VehicleDto> vehicles = vehicleService.getByWeightRange(min, max);
        return ResponseEntity.ok(vehicles);
    }
}
