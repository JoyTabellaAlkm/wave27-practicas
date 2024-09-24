package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    boolean addVehicles(Vehicle vehicleAdded);

    boolean thereIsAVehicleWithId(long id);
    
    Vehicle findById(long id);

    boolean editVehicle(Vehicle vehicle);

    boolean deleteById(Long id);
}
