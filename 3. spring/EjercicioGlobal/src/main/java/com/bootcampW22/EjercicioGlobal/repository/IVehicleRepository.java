package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Boolean add(Vehicle vehicle);

    List<Vehicle> getVehiclesByBrand(String brand);

    List<Double> getVehiclesSpeedByBrand(String brand);

    Vehicle updateVehicle(Vehicle vehicle);

    Vehicle updateMaxSpeed(long id, String maxSpeed);
}
