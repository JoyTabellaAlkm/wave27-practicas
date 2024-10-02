package com.meli.ejconcesionariaautos.service;

import com.meli.ejconcesionariaautos.dto.ResponseDto;
import com.meli.ejconcesionariaautos.dto.request.VehicleDto;
import com.meli.ejconcesionariaautos.dto.response.VehicleResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
    ResponseDto addVehicle(VehicleDto newVehicle);
    List<VehicleResponseDto> showAllVehicles();
    List<VehicleResponseDto> listVehiclesByDate(LocalDate since, LocalDate to);
    List<VehicleResponseDto> listVehiclesByPrice(int since, int to);
    VehicleResponseDto showVehicleById(int id);
}
