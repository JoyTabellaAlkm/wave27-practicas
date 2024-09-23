package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Boolean addVehicleAtList(Vehicle vehicle);
    Boolean delete(Vehicle vehicle);
    Vehicle findById(Long id);
}
