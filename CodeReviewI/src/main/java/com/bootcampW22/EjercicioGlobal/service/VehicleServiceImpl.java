package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(IVehicleRepository iVehicleRepository){

        this.vehicleRepository = iVehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }
     //1. Añadir nuevo vehiculo
    @Override
    public VehicleDto create(VehicleDto vehicleDto) {
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);

        vehicleRepository.save(vehicle);
        return mapper.convertValue(vehicle, VehicleDto.class);
    }
     //2.Buscar por color y por año
    @Override
    public List<VehicleDto> searchByColorAndYear(String color, int year) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = vehicleRepository.findByColorAndYear(color, year);

        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con el color " + color + " y año " + year);
        }

        return vehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    // 5.Añadir multiples vehiculos
    @Override
    public List<VehicleDto> addVehiclesInBatch(List<VehicleDto> vehiclesDto) {
        ObjectMapper mapper = new ObjectMapper();

        // Convertir la lista de VehicleDto a Vehicle
        List<Vehicle> vehicles = vehiclesDto.stream()
                .map(dto -> mapper.convertValue(dto, Vehicle.class))
                .collect(Collectors.toList());

        // Guardar los vehículos en el repositorio
        vehicles.forEach(vehicleRepository::save);

        // Convertir la lista de Vehicle de nuevo a VehicleDto para devolver
        return vehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

}
