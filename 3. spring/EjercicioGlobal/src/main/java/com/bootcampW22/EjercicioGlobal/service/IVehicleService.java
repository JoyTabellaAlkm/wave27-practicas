package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    VehicleDto addVehicle(VehicleDto vehicleDto);

    VehicleDto updateVehicle(long id, String maxSpeed);

    AverageSpeedDTO getAverageSpeedByBrand(String brand);

}
