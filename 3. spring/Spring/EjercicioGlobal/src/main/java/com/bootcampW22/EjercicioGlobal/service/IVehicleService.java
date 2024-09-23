package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDimenDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleWeightDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.OptionalDouble;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    String addVehicle(Vehicle vehicle);
    Boolean validate(Vehicle vehicle);
    List<Vehicle> findByColorAndYear(String color, int year);
    List<Vehicle> findByBrandAndRange(String brand, int start_year, int end_year);
    OptionalDouble findByBrandAverage(String brand);
    String addMultipleVehicle(List<Vehicle> vehicleList);
    String updateSpeed(Long id, int update_speed);
    List<Vehicle> findByFuelType(String type);
    String deleteVehicle(Long id);
    List<Vehicle> findByType(String type);
    String updateFuelType(Long id, String update_fuel);
    OptionalDouble findByCapacityAverage(String brand);
    List<VehicleDimenDto> findByDimension(double min_length, double max_length, double min_width, double max_width);
    List<VehicleWeightDto> findByWeight(double weight_min, double weight_max);

}
