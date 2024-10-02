package com.meli.ejconcesionariaautos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.ejconcesionariaautos.dto.ResponseDto;
import com.meli.ejconcesionariaautos.dto.request.VehicleDto;
import com.meli.ejconcesionariaautos.dto.response.VehicleResponseDto;
import com.meli.ejconcesionariaautos.entity.Vehicle;
import com.meli.ejconcesionariaautos.exception.NotFoundException;
import com.meli.ejconcesionariaautos.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IVehicleServiceImpl implements IVehicleService{
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public ResponseDto addVehicle(VehicleDto newVehicle){
        mapper.registerModule(new JavaTimeModule());
        Vehicle vehicle = mapper.convertValue(newVehicle, Vehicle.class);
        int idCreado = vehicleRepository.addVehicle(vehicle);
        return new ResponseDto("Añadido con éxito, id = %d".formatted(idCreado), HttpStatus.OK);
    }

    @Override
    public List<VehicleResponseDto> showAllVehicles() {
        return vehicleRepository.allVehicles().stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleResponseDto.class)).toList();
    }

    @Override
    public List<VehicleResponseDto> listVehiclesByDate(LocalDate since, LocalDate to) {
        return vehicleRepository.allVehicles().stream()
                .filter(vehicle -> vehicle.getManufacturingDate().isBefore(to))
                .filter(vehicle -> vehicle.getManufacturingDate().isAfter(since))
                .map(vehicle -> mapper.convertValue(vehicle, VehicleResponseDto.class))
                .toList();
    }

    @Override
    public List<VehicleResponseDto> listVehiclesByPrice(int since, int to) {
        return vehicleRepository.allVehicles().stream()
                .filter(vehicle -> vehicle.getPrice()>since)
                .filter(vehicle -> vehicle.getPrice()<to)
                .map(vehicle -> mapper.convertValue(vehicle, VehicleResponseDto.class))
                .toList();
    }

    @Override
    public VehicleResponseDto showVehicleById(int id) {
        VehicleResponseDto vehicleId = vehicleRepository.allVehicles().stream()
                .filter(vehicle -> vehicle.getId()==id)
                .map(vehicle -> mapper.convertValue(vehicle, VehicleResponseDto.class))
                .findFirst().orElse(null);
        if (vehicleId== null){
            throw new NotFoundException("Vehiculo con id %d no encontrado".formatted(id));
        }
        return vehicleId;
    }
}
