package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.request.VehicleUpdateDTO;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    void saveVehicle(Vehicle vehicle);

    List<Vehicle> getVehicleByColorAndYear(String color, Integer year);

    List<Vehicle> getVehicleByBrandAndYears(String brand, Integer startYear, Integer endYear);

    Double getAverageSpeedByBrand(String brand);

    void updateVehicleSpeed(Long id, VehicleUpdateDTO vehicleUpdateDTO);

    List<Vehicle> getVehicleByFuel(String fuel);

    void deleteVehicle(Long id);

    void updateFuel(Long id, VehicleUpdateDTO vehicle);

    Double getBrandAveragePassangers(String brand);

    List<Vehicle> getVehiclesByDimension(String length, String width);

    List<Vehicle> getVehiclesByWeight(Integer weightMin, Integer weightMax);
}
