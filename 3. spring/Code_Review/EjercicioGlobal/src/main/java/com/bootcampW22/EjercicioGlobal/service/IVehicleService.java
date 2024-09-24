package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    String addVehicle(VehicleDto vehicle);

    List<VehicleDto>  searchByColorAndYear(String color, int year);
    List<VehicleDto> seachByBrandAndYears(String brand, int yearInit, int yearEnd);

    Double averageSpeed(String brand);
    String addMultipleVehicles(List<VehicleDto> listaOfVehicles);

    String updateSpeed(Integer id, Integer velocidad);
    String deleteVehicle( Long id);

    List<VehicleDto> fuelType(String type);
    List<VehicleDto> typeTransmission(String type);
    String updateFuel(Long id, String fuel);

    Double getAverageCapacity(String brand);
    List<VehicleDto> dimensionsCalc(String length, String width);
    List<VehicleDto> getByWeight(int min, int max);


}
