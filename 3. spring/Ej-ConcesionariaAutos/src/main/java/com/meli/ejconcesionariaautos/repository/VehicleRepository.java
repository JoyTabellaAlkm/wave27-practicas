package com.meli.ejconcesionariaautos.repository;

import com.meli.ejconcesionariaautos.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();
    private int id = 0;

    public List<Vehicle> allVehicles(){
        return vehicles;
    }

    public int addVehicle(Vehicle vehicle){
        int idCreado = this.id;
        vehicle.setId(idCreado);
        this.id ++;
        vehicles.add(vehicle);
        return idCreado;
    }
}
