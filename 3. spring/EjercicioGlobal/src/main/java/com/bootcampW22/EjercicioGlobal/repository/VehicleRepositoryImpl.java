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
import java.util.stream.IntStream;

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
    public void save(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
    }

    @Override
    public void saveAll(List<Vehicle> vehicles) {
        listOfVehicles.addAll(vehicles);
    }

    @Override
    public Vehicle updateMaxSpeed(Long id, String maxSpeed) {
        int vehicleIndx = IntStream.range(0, listOfVehicles.size())
                .filter(i -> listOfVehicles.get(i).getId().equals(id))
                .findFirst()
                .orElse(-1);

        Vehicle vehicle = listOfVehicles.get(vehicleIndx);
        vehicle.setMax_speed(maxSpeed);
        listOfVehicles.set(vehicleIndx, vehicle);

        return vehicle;
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {
        listOfVehicles.remove(vehicle);
    }

    @Override
    public Vehicle updateFuel(Long id, String type) {
        int vehicleIndx = IntStream.range(0, listOfVehicles.size())
                .filter(i -> listOfVehicles.get(i).getId().equals(id))
                .findFirst()
                .orElse(-1);

        Vehicle vehicle = listOfVehicles.get(vehicleIndx);
        vehicle.setFuel_type(type);
        listOfVehicles.set(vehicleIndx, vehicle);

        return vehicle;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }
}
