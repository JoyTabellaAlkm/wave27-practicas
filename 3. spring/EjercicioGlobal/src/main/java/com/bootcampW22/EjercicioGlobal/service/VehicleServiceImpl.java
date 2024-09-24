package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.AlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.exception.InvalidVehicleException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
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

    @Override
    public String addVehicle(VehicleDto vehicleDto) {
        if(vehicleDto.getId() <1 || vehicleDto == null){
            throw new InvalidVehicleException("Datos del vehículo mal formados o incompletos.");
        }
        if(vehicleRepository.exists(vehicleDto.getId())) {
            throw new AlreadyExistsException("Identificador del vehículo ya existente.");
        }
        vehicleRepository.addVehicle(mapperToEntity(vehicleDto));
        return "Creado correctamente";
    }

    private Vehicle mapperToEntity(VehicleDto vehicleDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vehicleDto, Vehicle.class);
    }
}


