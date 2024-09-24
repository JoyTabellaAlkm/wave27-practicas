package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public boolean addVehicles(Vehicle vehicleAdded) {
        return listOfVehicles.add(vehicleAdded);
    }

    @Override
    public boolean thereIsAVehicleWithId(long id) {
        return listOfVehicles.stream().anyMatch(vehicle -> vehicle.getId() == id);
    }

    @Override
    public Vehicle findById(long id) {
        return listOfVehicles.stream().filter(vehicle -> vehicle.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean editVehicle(Vehicle vehicle) {
        return listOfVehicles.stream().filter(v -> v.getId().equals(vehicle.getId())).findFirst()
                .map(v -> {
                    v.setId(vehicle.getId());
                    v.setBrand(vehicle.getBrand());
                    v.setModel(vehicle.getModel());
                    v.setRegistration(vehicle.getRegistration());
                    v.setColor(vehicle.getColor());
                    v.setYear(vehicle.getYear());
                    v.setMax_speed(vehicle.getMax_speed());
                    v.setPassengers(vehicle.getPassengers());
                    v.setFuel_type(vehicle.getFuel_type());
                    v.setTransmission(vehicle.getTransmission());
                    v.setHeight(vehicle.getHeight());
                    v.setWidth(vehicle.getWidth());
                    v.setWeight(vehicle.getWeight());
                    return true;
                }).orElse(false);
    }

    @Override
    public boolean deleteById(Long id) {
        return listOfVehicles.remove(findById(id));
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }
}
