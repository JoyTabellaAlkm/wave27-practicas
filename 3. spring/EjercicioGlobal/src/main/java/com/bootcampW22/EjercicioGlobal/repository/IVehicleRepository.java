package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Boolean addVehicle(Vehicle vehicle);

    Boolean existVehicle(Long id);

    Vehicle getById(Long id);

    Boolean editVehicle(Vehicle vehicle);

    Boolean deleteVehicle(Vehicle vehicle);
}
