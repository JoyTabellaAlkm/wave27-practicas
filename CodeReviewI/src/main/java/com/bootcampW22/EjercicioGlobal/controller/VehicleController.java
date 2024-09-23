package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.ResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(IVehicleService iVehicleService){

        this.vehicleService = iVehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles() {
        List<VehicleDto> vehicles = vehicleService.searchAllVehicles();
        return ResponseEntity.ok(new ResponseDto<>(vehicles, 200));
    }

    // 1.Añadir un nuevo vehiculo
    @PostMapping("/vehicles")
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDto vehicle) {
        VehicleDto createdVehicle = vehicleService.create(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto<>(createdVehicle, 201));
    }

    //2. Busqueda por color y año
    @GetMapping("/vehicles/search")
    public ResponseEntity<?> searchVehiclesByColorAndYear(
            @RequestParam String color, @RequestParam int year) {

        List<VehicleDto> vehicles = vehicleService.searchByColorAndYear(color, year);
        if (vehicles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDto<>("No se encontraron vehículos con el color y año especificados.", 404));
        }
        return ResponseEntity.ok(new ResponseDto<>(vehicles, 200));
    }

    // 5. Añadir multiples vehiculos
    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> addVehiclesInBatch(@RequestBody List<VehicleDto> vehiclesDto) {
        try {
            // Validación de los campos
            for (VehicleDto vehicle : vehiclesDto) {
                if (vehicle.getBrand() == null || vehicle.getBrand().isEmpty()) {
                    throw new BadRequestException("El campo 'brand' no puede estar vacío.");
                }
                if (vehicle.getModel() == null || vehicle.getModel().isEmpty()) {
                    throw new BadRequestException("El campo 'model' no puede estar vacío.");
                }
                /* Se pueden añadir mas validaciones yo solo sume estas para no hacerlo muy extenso
                Estuve investigando y se puede usar una anotacion de spring que es @Valid */
            }
            // Si estamos ok, ahi si se agrega el vehiculo
            List<VehicleDto> createdVehicles = vehicleService.addVehiclesInBatch(vehiclesDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseDto<>(createdVehicles, HttpStatus.CREATED.value()));
        } catch (ConflictException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponseDto<>(e.getMessage(), HttpStatus.CONFLICT.value()));
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto<>(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        }
    }

}
