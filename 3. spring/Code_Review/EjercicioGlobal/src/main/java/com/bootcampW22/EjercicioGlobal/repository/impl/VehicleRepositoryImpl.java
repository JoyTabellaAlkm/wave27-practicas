package com.bootcampW22.EjercicioGlobal.repository.impl;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {

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
    public void addVehicle(Vehicle vehicle){
        listOfVehicles.add(vehicle);

    }
    public void change(int id, Vehicle vehicle){
        listOfVehicles.set(id, vehicle);
    }

    public void changeFuel(int id, Vehicle vehicle){
        int idPOSIBILIDAD= listOfVehicles.indexOf(vehicle);
        listOfVehicles.set(id,vehicle);
    }

    @Override
    public void deleteVehicle(int id) {
        listOfVehicles.remove(id);
    }

    public Boolean existByFuelType(String type){
        return listOfVehicles.stream().anyMatch(t->t.getFuel_type().equalsIgnoreCase(type));
    }
}
