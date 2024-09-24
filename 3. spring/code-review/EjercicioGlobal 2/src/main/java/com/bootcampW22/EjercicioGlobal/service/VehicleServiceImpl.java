package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.ResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;
    ObjectMapper mapper = new ObjectMapper();

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDto addVehicle(VehicleDto vehicleDto) {

        List<Vehicle> vehicleList = vehicleRepository.findAll();

        if (vehicleDto == null || !validateVehicleDto(vehicleDto)){
            throw new BadRequestException("Datos del vehículo mal formados o incompletos");
        }

        vehicleList.stream()
                .filter(vehicle -> Objects.equals(vehicle.getId(), vehicleDto.getId()))
                .findFirst()
                .ifPresentOrElse(
                        vehicle -> {
                            throw new ConflictException("El vehículo con id " + vehicleDto.getId() + " ya existe");
                        },
                        () -> {
                            vehicleRepository.addVehicle(mapper.convertValue(vehicleDto, Vehicle.class));
                        }
                );

        return new ResponseDto("Se creo el vehículo",401);
    }

    private boolean validateVehicleDto(VehicleDto vehicleDto){
        return vehicleDto.getId() != null && vehicleDto.getBrand() != null && !vehicleDto.getBrand().isBlank() &&
                vehicleDto.getModel() != null && !vehicleDto.getModel().isBlank() &&
                vehicleDto.getRegistration() != null && !vehicleDto.getRegistration().isBlank() &&
                vehicleDto.getYear() > 0 && vehicleDto.getColor() != null && !vehicleDto.getColor() .isBlank() &&
                vehicleDto.getMax_speed() != null && !vehicleDto.getMax_speed().isBlank() &&
                vehicleDto.getFuel_type() != null && !vehicleDto.getFuel_type().isBlank() &&
                vehicleDto.getTransmission() != null && !vehicleDto.getTransmission().isBlank() &&
                vehicleDto.getPassengers() > 0 && vehicleDto.getHeight() > 0 &&
                vehicleDto.getWidth() > 0 && vehicleDto.getWeight() > 0;
    }
}
