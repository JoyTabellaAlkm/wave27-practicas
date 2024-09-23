package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
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

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }
    /* 1. Añadir vehiculo: Para poder implementar la parte de UUID, tuve que primero cambiar a java 21
    y ademas tuve que modificar el atributo id en VehiculeDto y vehicle, para que sea de tipo correcto y
    no long. Luego de eso tuve que modificar el json, haciendo un script de python para que los ids no fueran long*/

    @Override
    public Vehicle save(Vehicle vehicle) {
        // Verifica si el registro ya existe
        if (listOfVehicles.stream().anyMatch(v -> v.getRegistration().equals(vehicle.getRegistration()))) {
            throw new ConflictException("El vehículo con registro " + vehicle.getRegistration() + " ya existe.");
        }

        // Asigna un nuevo UUID al vehículo
        vehicle.setId(UUID.randomUUID());
        listOfVehicles.add(vehicle);
        return vehicle;
    }


    //2.Busqueda por color y año
    @Override
    public List<Vehicle> findByColorAndYear(String color, int year) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle
                        .getColor()
                        .equalsIgnoreCase(color) && vehicle.getYear() == year)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Vehicle> findById(UUID id) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst();
    }

}
