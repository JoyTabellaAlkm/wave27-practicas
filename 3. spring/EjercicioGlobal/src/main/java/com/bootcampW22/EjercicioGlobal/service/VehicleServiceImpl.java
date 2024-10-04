package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.VelocityDTO;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleAlreadyExistException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleNotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    @Autowired
    ModelMapper modelMapper;

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
    public VehicleDto addVehicle(VehicleDto vehicleDto) {

        Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);

        boolean vehicleAlreadyExists = vehicleRepository.add(vehicle);

        if(vehicleAlreadyExists){
            throw new VehicleAlreadyExistException("Identificador del vehículo ya existente.");
        }

        return vehicleDto;
    }

    @Override
    public VehicleDto updateVehicle(long id, String maxSpeed) {
        Vehicle vehicle =  vehicleRepository.updateMaxSpeed(id,maxSpeed);
        VehicleDto vehicleDto = modelMapper.map(vehicle,VehicleDto.class);

        if(vehicleDto == null) throw new NotFoundException("El vehiculo solicitado no existe");

        return vehicleDto;
    }

    /* VERSION DEL CODE REVIEW
    @Override
    public AverageSpeedDTO getAverageSpeedByBrand(String brand) {
        List<Vehicle> vehicles = vehicleRepository.getVehiclesByBrand(brand);
        AverageSpeedDTO averageSpeedDTO = new AverageSpeedDTO();
        double averageSpeed = 0d;

        //Agregué esta excepción. Antes utilizaba el notFoundException que viene por defecto
        if(vehicles.isEmpty()) throw new VehicleNotFoundException("No hay vehiculos de esa marca");

        averageSpeed = vehicles.stream()
                        .mapToDouble( value -> Double.parseDouble(value.getMax_speed()))
                        .average()
                        .getAsDouble();

        averageSpeedDTO.setAverage_speed( Double.toString(averageSpeed));

        return averageSpeedDTO;
    }
    */

    @Override
    public AverageSpeedDTO getAverageSpeedByBrand(String brand) {
        /*Si mal no recuerdo, lean me recomendó que en lugar de traerme una lista con los vehículos,
        me trajera directamente solo los datos que necesito (en este caso las velocidades) */
        List<Double> vehiclesSpeed = vehicleRepository.getVehiclesSpeedByBrand(brand);
        AverageSpeedDTO averageSpeedDTO = new AverageSpeedDTO();
        double averageSpeedValue;

        //Agregué esta excepción. Antes utilizaba el notFoundException que viene por defecto
        if(vehiclesSpeed.isEmpty()) throw new VehicleNotFoundException("No hay vehículos de esa marca");

        averageSpeedValue = vehiclesSpeed.stream().
                mapToDouble(Double::doubleValue).
                average().
                orElse(0.0d);

        averageSpeedDTO.setAverage_speed( Double.toString(averageSpeedValue));

        return averageSpeedDTO;
    }

}
