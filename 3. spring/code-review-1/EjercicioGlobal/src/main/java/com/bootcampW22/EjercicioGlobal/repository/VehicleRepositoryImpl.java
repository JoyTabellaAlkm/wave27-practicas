package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public boolean exists(Long id) {
        return listOfVehicles.stream().anyMatch(v -> Objects.equals(v.getId(), id));
    }

    @Override
    public void save(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
    }

    @Override
    public void save(List<Vehicle> vehicles) {
        vehicles.forEach(this::save);
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst();
    }

    @Override
    public void update(Vehicle vehicle) {
        Vehicle vehicleInList = findById(vehicle.getId())
                .orElseThrow(() -> new NotFoundException("Id %d not found".formatted(vehicle.getId())));
        int index = listOfVehicles.indexOf(vehicleInList);

        listOfVehicles.remove(vehicleInList);
        listOfVehicles.add(index, vehicle);
    }

    @Override
    public void delete(Long id) {
        Vehicle vehicle = findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el vehículo."));

        listOfVehicles.remove(vehicle);
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
