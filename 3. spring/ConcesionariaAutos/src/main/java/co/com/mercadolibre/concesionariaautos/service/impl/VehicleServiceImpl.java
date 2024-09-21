package co.com.mercadolibre.concesionariaautos.service.impl;

import co.com.mercadolibre.concesionariaautos.dto.request.VehicleCreateRequestDTO;
import co.com.mercadolibre.concesionariaautos.dto.response.VehicleAllInfoResponseDTO;
import co.com.mercadolibre.concesionariaautos.dto.response.VehicleCreatedResponseDTO;
import co.com.mercadolibre.concesionariaautos.dto.response.VehicleResponseDTO;
import co.com.mercadolibre.concesionariaautos.entity.Vehicle;
import co.com.mercadolibre.concesionariaautos.exception.UnableToCreateVehicleException;
import co.com.mercadolibre.concesionariaautos.exception.VehiclesNotFoundException;
import co.com.mercadolibre.concesionariaautos.repository.IVehicleRepository;
import co.com.mercadolibre.concesionariaautos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    IVehicleRepository vehicleRepository;

    @Override
    public VehicleCreatedResponseDTO createVehicle(VehicleCreateRequestDTO vehicleRequest) {
        try{
            Vehicle vehicle = vehicleRepository.createVehicle(vehicleRequest);
            VehicleCreatedResponseDTO vehicleCreatedResponseDTO = new VehicleCreatedResponseDTO(vehicle.getId(),vehicle.getBrand(),vehicle.getModel());
            return vehicleCreatedResponseDTO;
        }catch (Exception e){
            throw  new UnableToCreateVehicleException("No se pudo crear el vehiculo.");
        }
    }

    @Override
    public List<VehicleResponseDTO> seeAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.seeAllVehicles();
        if(vehicleList.isEmpty()){
            throw new VehiclesNotFoundException("No hay vehiculos registrados aún.");
        }
        List<VehicleResponseDTO> vehicleListResponse = new ArrayList<>();
        for(Vehicle vehicle : vehicleList){
            vehicleListResponse.add(new VehicleResponseDTO(
                    vehicle.getBrand(),vehicle.getModel(),vehicle.getManufacturingDate(),vehicle.getNumberOfKilometers(),vehicle.getDoors(),vehicle.getPrice(),vehicle.getCurrency(),vehicle.getCountOfOwners()
            ));
        }
        return vehicleListResponse;
    }

    @Override
    public List<VehicleResponseDTO> seeVehiclesByDate(LocalDate since, LocalDate to) {
        List<VehicleResponseDTO> filteredVehicles;
        filteredVehicles= seeAllVehicles().stream()
                .filter(vehicle -> vehicle.getManufacturingDate().isAfter(since) && vehicle.getManufacturingDate().isBefore(to))
                .toList();
        if(filteredVehicles.isEmpty()){
            throw new VehiclesNotFoundException("No se registraron vehiculos que contengan una fecha de manufacturación en este rango de tiempo.");
        }

        return filteredVehicles;
    }

    @Override
    public List<VehicleResponseDTO> seeVehiclesByPrice(Double since, Double to) {
        List<VehicleResponseDTO> filteredVehicles;
        filteredVehicles= seeAllVehicles().stream()
                .filter(vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to)
                .toList();
        if(filteredVehicles.isEmpty()){
            throw new VehiclesNotFoundException("No se registraron vehiculos que contengan en ese rango de precio.");
        }

        return filteredVehicles;
    }

    @Override
    public VehicleAllInfoResponseDTO seeAllInfoVehicle(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.seeAllVehicles().stream().filter(ve -> ve.getId().equals(id)).findFirst();
        if(vehicle.isEmpty()){
            throw new VehiclesNotFoundException("No hay vehiculos con este id.");
        }
        Vehicle vehicle1 = vehicle.get();
        return new VehicleAllInfoResponseDTO(vehicle1.getBrand(),vehicle1.getModel(),vehicle1.getManufacturingDate(),
                vehicle1.getNumberOfKilometers(),vehicle1.getDoors(),vehicle1.getPrice(),vehicle1.getCurrency(),
                vehicle1.getServices(),vehicle1.getCountOfOwners());
    }
}

