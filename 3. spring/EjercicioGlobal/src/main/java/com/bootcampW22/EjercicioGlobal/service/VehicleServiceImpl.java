package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.request.VehicleBrandDTO;
import com.bootcampW22.EjercicioGlobal.dto.request.VehicleColorYearDTO;
import com.bootcampW22.EjercicioGlobal.dto.request.VehicleSpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.response.AverageSpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.response.CreatedVehicleDTO;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.NotMatchingBrandException;
import com.bootcampW22.EjercicioGlobal.exception.NotMatchingResultsException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleIdAlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{
    @Autowired
    IVehicleRepository vehicleRepository;

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
    public CreatedVehicleDTO createVehicle(VehicleDto newVehicle){
        if (vehicleRepository.findById(newVehicle.getId()) != null){
                throw new VehicleIdAlreadyExistsException("El identificador del vehículo ya existe");
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setId(newVehicle.getId());
        vehicle.setBrand(newVehicle.getBrand());
        vehicle.setModel(newVehicle.getModel());
        vehicle.setYear(newVehicle.getYear());
        vehicle.setRegistration(newVehicle.getRegistration());
        vehicle.setColor(newVehicle.getColor());
        vehicle.setYear(newVehicle.getYear());
        vehicle.setMax_speed(newVehicle.getMax_speed());
        vehicle.setPassengers(newVehicle.getPassengers());
        vehicle.setFuel_type(newVehicle.getFuel_type());
        vehicle.setTransmission(newVehicle.getTransmission());
        vehicle.setHeight(newVehicle.getHeight());
        vehicle.setWeight(newVehicle.getWeight());
        vehicle.setWidth(newVehicle.getWidth());

        Long createdId = vehicleRepository.saveVehicle(vehicle);
        return new CreatedVehicleDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel());
    }

    @Override
    public List<VehicleDto> searchVehiclesByColorAndYear(VehicleColorYearDTO vehicleColorYearDTO){
        List<VehicleDto> vehicleDtos = searchAllVehicles();
        List<VehicleDto> filteredVehicleList = vehicleDtos.stream()
                .filter(v -> Objects.equals(v.getColor(), vehicleColorYearDTO.getColor()))
                .filter(v -> v.getYear() == vehicleColorYearDTO.getYear())
                .toList();

        if (filteredVehicleList.isEmpty()){
            throw new NotMatchingResultsException("No hay vehiculos que cumplan con esos criterios");
        }
        return filteredVehicleList;
    }

    public AverageSpeedDTO calculateAverageSpeed(VehicleBrandDTO vehicleBrandDTO){
        String brand = vehicleBrandDTO.getBrand();
        List<VehicleDto> vehicleDtos = searchByBrand(brand);
        if (vehicleDtos.isEmpty()){
            throw new NotMatchingBrandException("No existen vehiculos de esa marca");
        }
        double averageSpeed=vehicleDtos.stream()
                .mapToDouble(v -> Double.parseDouble(v.getMax_speed()))
                .average()
                .orElse(0.0);
        return new AverageSpeedDTO(vehicleBrandDTO.getBrand(), averageSpeed);
    }

    public List<VehicleDto> searchByBrand(String brand){
        List<VehicleDto> vehicleDtos = searchAllVehicles();
        return vehicleDtos.stream()
                .filter(vehicleDto -> Objects.equals(vehicleDto.getBrand(), brand))
                .toList();
    }

//    public VehicleDto updateMaxSpeed(VehicleSpeedDTO vehicleSpeedDTO){
//        Vehicle vehicle = vehicleRepository.findById(vehicleSpeedDTO.getId());
//        vehicle.setMax_speed(vehicleSpeedDTO.getMaxSpeed());
//        if(!vehicleRepository.updateVehicle(vehicle)){
//            throw new VehicleNotFoundException("No se encontró el vehiculo");
//        }
//        return
//    }
}
