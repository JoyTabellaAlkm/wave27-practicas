package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    VehicleDto create(VehicleDto vehicleDto);
    List<VehicleDto> searchByColorAndYear(String color, int year);
    List<VehicleDto> addVehiclesInBatch(List<VehicleDto> vehiclesDto);
}
