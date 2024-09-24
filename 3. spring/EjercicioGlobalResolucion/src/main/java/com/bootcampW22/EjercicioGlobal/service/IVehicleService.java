package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.response.VehicleResponseDTO;

import java.util.List;

public interface IVehicleService {

    List<VehicleDto> searchAllVehicles();

    VehicleResponseDTO addVehicles(VehicleDto vehicleDto);

    List<VehicleDto> searchVehicleByColorAndYear(String color, int year);

    List<VehicleDto> searchByBrandAndYear(String brand, int starYear, int endYear);

    VehicleResponseDTO averageSpeedByBrand(String brand);

    VehicleResponseDTO addListVehicles(List<VehicleDto> vehicleDtos);

    VehicleResponseDTO updateSpeed(Long id, Double updateSpeed);

    List<VehicleDto> searByFuelType(String type);

    VehicleResponseDTO deleteById(Long id);

    List<VehicleDto> searchByTransmissionType(String type);

    VehicleResponseDTO updateFuelById(Long id, String updateFuel);

    VehicleResponseDTO averageCapacityByBrand(String brand);

    List<VehicleDto> getByRangeWeight(Double weightMin, Double weightMax);

    List<VehicleDto> getVehiclesByDimension(String lengthValue, String widthValue);
}
