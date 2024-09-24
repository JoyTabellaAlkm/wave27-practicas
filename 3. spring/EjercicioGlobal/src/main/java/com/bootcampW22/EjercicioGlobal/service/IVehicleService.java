package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    String addVehicle(VehicleDto vehicleDto);

    List<VehicleDto> searchByColorYear(String color, Integer year);

    List<VehicleDto> searchByBrandYear(String brand, Integer startYear, Integer endYear);

    Double getAverageByBrand(String brand);

    String addMultipleVehicles(List<VehicleDto> listVehicleDto);

    String editSpeed(Long id, Double speed);

    List<VehicleDto> getVehiclesByFuel(String type);

    String deleteVehicle(Long id);

    List<VehicleDto> getVehiclesByTransmission(String type);

    String editFuel(Long id, String fuel);

    Double getAverageCapacityByBrand(String brand);

    List<VehicleDto> getVehiclesByDimension(String lengthValue, String widthValue);

    List<VehicleDto> getByRangeWeight(Double weightMin, Double weightMax);
}
