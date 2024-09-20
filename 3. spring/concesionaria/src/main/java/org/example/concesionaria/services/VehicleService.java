package org.example.concesionaria.services;

import org.example.concesionaria.dto.createVehicleDTO;
import org.example.concesionaria.entities.Vehicle;
import org.example.concesionaria.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public void createVehicle(createVehicleDTO dto) {
        Vehicle vehicle = new Vehicle(
                dto.getBrand(),
                dto.getModel(),
                dto.getManufacturingDate(),
                dto.getNumberOfKilometers(),
                dto.getDoors(),
                dto.getPrice(),
                dto.getCurrency(),
                dto.getServices(),
                dto.getCountOfOwners()
        );
        vehicle.id = UUID.randomUUID();
        this.vehicleRepository.createVehicle(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return this.vehicleRepository.getVehicles();
    }

    public List<Vehicle> getVehiclesByDates(Date since, Date to) {
        return this.vehicleRepository.getVehiclesByDates(since, to);
    }

    public List<Vehicle> getVehiclesByPrice(Integer since, Integer to) {
        return this.vehicleRepository.getVehiclesByPrice(since, to);
    }

    public Vehicle getVehicleById(UUID id) {
        return this.vehicleRepository.getVehicleById(id);
    }
}
