package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Vector;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    void saveVehicle(Vehicle vehicle);

    Boolean idExist(Long id);

    void updateSpeed(Long id, String speed);

    void deleteVehicle(Vehicle vehicle);

    Vehicle getVehicleById(Long id);

    void updateFuel(Long id, String fuel);

}
