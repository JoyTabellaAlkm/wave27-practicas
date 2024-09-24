package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    VehicleDto saveVehicle(VehicleDto vehicleDto);
    List<VehicleDto> findByColorAndYear(String color, int year);
    double findAverageSpeed(String brand);
    List<VehicleDto> saveVehicles(List<VehicleDto> vehicles);
    VehicleDto updateMaxSpeed(Long id, String maxSpeed);
    List<VehicleDto> findVehiclesByFuelType(String type);
    VehicleDto deleteVehicleById(Long id);
    List<VehicleDto> findByTransmission(String type);
    VehicleDto updateFuel(Long id, String type);
    double calculateCapacityByBrand(String brand);
    List<VehicleDto> findVehiclesByDimensions(String length, String width);
    List<VehicleDto> findVehiclesByWeigth(String min, String max);
}
