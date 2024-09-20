package org.example.concesionaria.repository;

import org.example.concesionaria.entities.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class VehicleRepository {
    private List<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    public void createVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public List<Vehicle> getSelectedVehicles(List<String> strings){
        List<Vehicle> selectedVehicles = new ArrayList<>();
        for(Vehicle vehicle : this.vehicles){
            if(strings.contains(vehicle.getModel())){
                selectedVehicles.add(vehicle);
            }
        }
        return selectedVehicles;
    }

    public List<Vehicle> getVehiclesByDates(Date since, Date to) {
        //fix compare
        return this.vehicles.stream().filter(v -> v.getManufacturingDate().compareTo(since) > 0 && v.getManufacturingDate().compareTo(to) > 0).toList();
    }

    public List<Vehicle> getVehiclesByPrice(Integer since, Integer to) {
        return this.vehicles.stream().filter(v -> v.getPrice() >= since && v.getPrice() <= to).toList();
    }

    public Vehicle getVehicleById(UUID id) {
        return this.vehicles.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }
}
