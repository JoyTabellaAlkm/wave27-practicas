package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    void create(VehicleDto vehicleDto);
    List<VehicleDto> getVehiclesByColorAndYear(String color, Integer year);
    List<VehicleDto> getByBrandAndYearRange(String brand, Integer startYear, Integer endYear);
    double getAverageSpeed(String brand);
    void create(List<VehicleDto> vehicleDtos);
    void updateSpeed(Long id, String newSpeed);
    List<VehicleDto> getByDimensions(String length, String width);
    List<VehicleDto> getByWeightRange(Double minWeight, Double maxWeight);
    List<VehicleDto> getByFuelType(String fuelType);
    void delete(Long id);
    List<VehicleDto> getByTransmission(String transmission);
    void updateFuelType(Long id, String newFuelType);
    Double getAverageCapacity(String brand);
}
