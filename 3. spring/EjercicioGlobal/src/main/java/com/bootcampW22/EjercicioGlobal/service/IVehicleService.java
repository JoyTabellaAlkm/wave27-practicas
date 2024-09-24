package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    String addVehicle(VehicleDto vehicleDto);
}
