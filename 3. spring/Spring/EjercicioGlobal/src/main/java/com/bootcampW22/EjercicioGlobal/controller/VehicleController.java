package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    // Listado de vehículos
    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    // 1. AÑADIR UN VEHICULO | ANDA
    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(vehicleService.addVehicle(vehicle), HttpStatus.CREATED);
    }

    // 2. BUSCAR VEHÍCULOS POR COLOR Y AÑO | ANDA
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> findByColorAndYear(@PathVariable String color, @PathVariable int year) {
        return new ResponseEntity<>(vehicleService.findByColorAndYear(color, year), HttpStatus.OK);
    }

    // 3. BUSCAR VEHÍCULOS POR MARCA Y RANGO DE AÑOS | ANDA
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> findByBrandAndRange(@PathVariable String brand, @PathVariable int start_year, @PathVariable int end_year){
        return new ResponseEntity<>(vehicleService.findByBrandAndRange(brand, start_year, end_year), HttpStatus.OK);
    }

    // 4. CONSULTAR VELOCIDAD PROMEDIO POR MARCA | ANDA
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> findByBrandAverage(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.findByBrandAverage(brand), HttpStatus.OK);
    }

    // 5. AÑADIR MÚLTIPLES VEHÍCULOS | ANDA
    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> addMultipleVehicle(@RequestBody List<Vehicle> vehicleList){
        return new ResponseEntity<>(vehicleService.addMultipleVehicle(vehicleList), HttpStatus.CREATED);
    }

    // 6. ACTUALIZAR VELOCIDAD MÁXIMA DE UN VEHÍCULO | ANDA
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable Long id, @RequestBody int update_speed){
        return new ResponseEntity<>(vehicleService.updateSpeed(id, update_speed), HttpStatus.OK);
    }

    // 7. LISTAR VEHÍCULOS POR TIPO DE COMBUSTIBLE | ANDA
    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> findByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.findByFuelType(type), HttpStatus.OK);
    }

    // 8. ELIMINAR UN VEHÍCULO | ANDA
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.NO_CONTENT);
    }

    // 9. BUSCAR VEHÍCULOS POR TIPO DE TRANSMISIÓN | ANDA
    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<?> findByType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.findByType(type), HttpStatus.OK);
    }

    // 10. ACTUALIZAR EL TIPO DE COMBUSTIBLE DE UN VEHÍCULO | ANDA
    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> updateFuelType(@PathVariable Long id, @RequestBody String update_fuel){
        return new ResponseEntity<>(vehicleService.updateFuelType(id, update_fuel),HttpStatus.OK);
    }

    // 11. OBTENER LA CAPACIDAD PROMEDIO DE PERSONAS POR MARCA | ANDA
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> findByCapacityAverage(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.findByCapacityAverage(brand), HttpStatus.OK);
    }

    // 12. BUSCAR VEHÍCULOS POR DIMENSIONES
    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> findByDimension(@RequestParam double min_length, @RequestParam double max_length,
                                             @RequestParam double min_width, @RequestParam double max_width){
        return new ResponseEntity<>(vehicleService.findByDimension(min_length, max_length, min_width, max_width), HttpStatus.OK);
    }

    // 13. LISTAR VEHÍCULOS POR RANGO DE PESO
    @GetMapping("/vehicles/weight")
    public ResponseEntity<?> findByWeight(@RequestParam double weight_min, @RequestParam double weight_max){
        return new ResponseEntity<>(vehicleService.findByWeight(weight_min, weight_max), HttpStatus.OK);
    }
}
