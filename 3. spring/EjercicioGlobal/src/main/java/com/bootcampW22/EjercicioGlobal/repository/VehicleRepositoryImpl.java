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
import java.util.stream.Collectors;

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

    public Boolean add(Vehicle vehicle){
        boolean exists = idExists(vehicle.getId());

        if(!exists){
            listOfVehicles.add(vehicle);
        }

        return exists;

    }

    @Override
    public List<Vehicle> getVehiclesByBrand(String brand) {
        return listOfVehicles.stream().filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand)).toList();
    }

    @Override
    public List<Double> getVehiclesSpeedByBrand(String brand) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .mapToDouble(vehicle -> Double.parseDouble(vehicle.getMax_speed()))
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle updateVehicle(Vehicle newVehicle) {
        Boolean exists = idExists(newVehicle.getId());
        Vehicle vehicle;

        if(exists){
            vehicle = getVehicle(newVehicle.getId());
            vehicle = newVehicle;
        }else{
            vehicle =  null;
        }

        return vehicle;
    }

    @Override
    public Vehicle updateMaxSpeed(long id, String maxSpeed) {
        Boolean exists = idExists(id);
        Vehicle vehicle;

        if(exists){
            vehicle = getVehicle(id);
            vehicle.setMax_speed(maxSpeed);
        }else{
            vehicle =  null;
        }

        return vehicle;
    }

    private boolean idExists(long id){
        return listOfVehicles.stream().anyMatch( vehicle -> vehicle.getId() == id);
    }

    private Vehicle getVehicle(long id){
        return listOfVehicles.stream().filter( vehicle -> vehicle.getId() == id).findFirst().get();
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
