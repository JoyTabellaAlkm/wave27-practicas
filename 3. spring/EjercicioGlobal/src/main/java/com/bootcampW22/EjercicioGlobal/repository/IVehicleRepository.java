package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    void save(Vehicle vehicle);
    void saveAll(List<Vehicle> vehicles);
    Vehicle updateMaxSpeed(Long id, String maxSpeed);
    void deleteVehicle(Vehicle vehicle);
    Vehicle updateFuel(Long id, String type);
}
