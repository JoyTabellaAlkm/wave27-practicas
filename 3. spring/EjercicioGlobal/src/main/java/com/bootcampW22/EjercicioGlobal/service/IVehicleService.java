package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.request.VehicleBrandDTO;
import com.bootcampW22.EjercicioGlobal.dto.request.VehicleColorYearDTO;
import com.bootcampW22.EjercicioGlobal.dto.request.VehicleSpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.response.AverageSpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.response.CreatedVehicleDTO;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    CreatedVehicleDTO createVehicle(VehicleDto newVehicle);
    List<VehicleDto> searchVehiclesByColorAndYear(VehicleColorYearDTO vehicleColorYearDTO);
    AverageSpeedDTO calculateAverageSpeed(VehicleBrandDTO vehicleBrandDTO);
    List<VehicleDto> searchByBrand(String brand);
    VehicleDto updateMaxSpeed(VehicleSpeedDTO vehicleSpeedDTO);
}

