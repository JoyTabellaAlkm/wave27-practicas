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
import java.util.Objects;

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
    public Vehicle findById(Long id){
        return listOfVehicles.stream()
                .filter(vehicle -> Objects.equals(vehicle.getId(), id))
                .findFirst()
                .orElse(null);
    }
    @Override
    public Long saveVehicle(Vehicle vehicle){
        listOfVehicles.add(vehicle);
        return vehicle.getId();
    }

    public boolean updateVehicle(Vehicle vehicle){
        for (int i=0;i< listOfVehicles.size(); i++){
            if (Objects.equals(vehicle.getId(), listOfVehicles.get(i).getId())){
                listOfVehicles.set(i,vehicle);
                return true;
            }
        }
        return false;
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
