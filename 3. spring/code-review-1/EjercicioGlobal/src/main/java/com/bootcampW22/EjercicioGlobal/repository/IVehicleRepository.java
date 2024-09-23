package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    boolean exists(Long id);
    void save(Vehicle vehicle);
    void save(List<Vehicle> vehicles);
    Optional<Vehicle> findById(Long id);
    void update(Vehicle vehicle);
    void delete(Long id);
}
