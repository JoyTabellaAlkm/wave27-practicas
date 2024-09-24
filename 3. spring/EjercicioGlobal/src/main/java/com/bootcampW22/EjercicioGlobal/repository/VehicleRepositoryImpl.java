package com.bootcampW22.EjercicioGlobal.repository;

import ch.qos.logback.core.joran.event.BodyEvent;
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

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }

    @Override
    public void saveVehicle(Vehicle vehicle){
        this.listOfVehicles.add(vehicle);
    }

    @Override
    public Boolean idExist(Long id){
        return this.listOfVehicles.stream()
                .anyMatch(vehicle -> vehicle.getId().equals(id));
    }

    @Override
    public void updateSpeed(Long id, String speed){
        this.listOfVehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .ifPresent(vehicle -> vehicle.setMax_speed(speed));
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {
        this.listOfVehicles.remove(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return this.listOfVehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateFuel(Long id, String fuel) {
        this.listOfVehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .ifPresent(vehicle -> vehicle.setFuel_type(fuel));
    }
}
