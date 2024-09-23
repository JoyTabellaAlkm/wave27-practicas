package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Vehicle save(Vehicle vehicle);

    List<Vehicle> findByColorAndYear(String color, int year);

    Optional<Vehicle> findById(UUID id);
}
