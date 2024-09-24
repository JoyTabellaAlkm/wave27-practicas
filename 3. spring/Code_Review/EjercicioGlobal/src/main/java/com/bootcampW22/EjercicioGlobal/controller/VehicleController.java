package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.impl.VehicleServiceImpl;
import jakarta.servlet.ServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.invoker.HttpRequestValues;

import java.util.List;

@RestController
@RequestMapping
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    /**
     * 1: Añadir un vehículo
     */
    @PostMapping("/vehicles")
    public ResponseEntity<?> addVechicle(@RequestBody VehicleDto vehicle){

        return new ResponseEntity<>(vehicleService.addVehicle(vehicle), HttpStatus.CREATED);
    }

    /**
     * 2: Buscar vehículos por color y año
     * @param color
     * @param year
     * @return
     */
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> searchByColorAndYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.searchByColorAndYear(color, year), HttpStatus.OK);
    }

    /**
     * 3: Buscar vehículos por marca y rango de años
     * @param brand
     * @param start_year
     * @param end_year
     * @return
     */
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> seachByBrandAndYears(@PathVariable String brand, @PathVariable int start_year, @PathVariable  int end_year){
        return new ResponseEntity<>(vehicleService.seachByBrandAndYears(brand, start_year, end_year), HttpStatus.OK);
    }

    /**
     * 4: Consultar velocidad promedio por marca
     * @param brand
     * @return
     */
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> averageSpeed(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageSpeed(brand), HttpStatus.OK);
    }

    /**
     * 5: Añadir múltiples vehículos
     * @param listaDeVehiculos
     * @return
     */
    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> addMultipleVehicles(@RequestBody List<VehicleDto> listaDeVehiculos){
        return new ResponseEntity<>(vehicleService.addMultipleVehicles(listaDeVehiculos), HttpStatus.CREATED);
    }

    /**
     * 6: Actualizar velocidad máxima de un vehículo
     * @param id
     * @param velocidad
     * @return
     */
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpead(@PathVariable Integer id, @RequestBody Integer velocidad) {
        try {
            vehicleService.updateSpeed(id, velocidad);
            return ResponseEntity.ok("Velocidad del vehículo actualizada exitosamente");
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Velocidad mal formada o fuera de rango.");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el vehículo");
        }
    }

    /**
     * 7: Listar vehículos por tipo de combustible
     * @param type
     * @return
     */
    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> fuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.fuelType(type), HttpStatus.OK);
    }


    /**
     * 8: Eliminar un vehículo
     * @param id
     * @return
     */
    @DeleteMapping("/vehiculos/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.OK);
    }

    /**
     * 9: Buscar vehículos por tipo de transmisión
     * @param type
     * @return
     */
    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<?>  typeTransmission(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.typeTransmission(type), HttpStatus.OK);
    }

    /**
     * 10: Actualizar el tipo de combustible de un vehículo
     * @param id
     * @param fuel
     * @return
     */
    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> updateFuel(@PathVariable Long id, @RequestBody String fuel) {

            return new ResponseEntity<>(vehicleService.updateFuel(id, fuel), HttpStatus.OK);
    }

    /**
     * 11: Actualizar el tipo de combustible de un vehículo
     * @param brand
     * @return
     */
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAverageCapacity(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getAverageCapacity(brand), HttpStatus.OK);
    }


    /**
     * 12: Buscar vehículos por dimensiones
     * @param length
     * @param width
     * @return
     */
    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> dimensions(@RequestParam String length, @RequestParam String width){
        return new ResponseEntity<>(vehicleService.dimensionsCalc(length,width), HttpStatus.OK);
    }

    @GetMapping("/vehicles/weight")
    public ResponseEntity<?> listByWeight(@RequestParam int min, @RequestParam int max){
        return new ResponseEntity<>(vehicleService.getByWeight(min, max), HttpStatus.OK);
    }


}


