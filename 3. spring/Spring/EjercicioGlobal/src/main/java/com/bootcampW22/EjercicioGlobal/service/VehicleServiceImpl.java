package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDimenDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleWeightDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadSintaxisException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleExistsException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    @Autowired
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
    public Boolean validate(Vehicle vehicle){
        if(vehicle == null || vehicle.getId() == null || vehicle.getId() < 0 ||
                vehicle.getBrand() == null || vehicle.getModel() == null || vehicle.getRegistration() == null ||
                vehicle.getColor() == null || (vehicle.getYear() > 1890 && vehicle.getYear() < 2024) ||
                vehicle.getMax_speed() < 0|| vehicle.getPassengers() < 2 || vehicle.getPassengers() > 10 ||
                vehicle.getFuel_type() == null || vehicle.getTransmission() == null ||
                vehicle.getHeight() < 0.0 || vehicle.getWeight() < 0.0 || vehicle.getWidth() < 0.0){

            return false;
    }
        return true;
    }

    @Override
    public String addVehicle(Vehicle vehicle){
        if(vehicle == null){
            throw new BadSintaxisException("Campos vacios o mal completados");
        }
        Vehicle vehicleInput = vehicleRepository.findById(vehicle.getId());
        if(vehicleInput != null){
            throw new VehicleExistsException("El identificador: " + vehicle.getId() + ", ya existe.");
        }
        vehicleRepository.addVehicleAtList(vehicle);
        return "Vehículo creado con éxito!";
    }

    @Override
    public List<Vehicle> findByColorAndYear(String color, int year){
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        List<Vehicle> vehicleFilter = vehicleList.stream()
                .filter(vehicle -> {
                    boolean colorMatches = vehicle.getColor().equalsIgnoreCase(color);
                    boolean yearMatches = vehicle.getYear() == year;
                    System.out.println("Comparando: Color: " + color + " con " + vehicle.getColor() +
                            ", Año: " + year + " con " + vehicle.getYear() +
                            " => Coincide: " + (colorMatches && yearMatches));
                    return colorMatches && yearMatches;
                }).toList();

        if(vehicleFilter.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return  vehicleFilter;
    }

    @Override
    public List<Vehicle> findByBrandAndRange(String brand, int start_year, int end_year){
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        List<Vehicle> vehicleFilter = vehicleList.stream().filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand)).filter(
                vehicle ->  vehicle.getYear() >= start_year && vehicle.getYear() <= end_year).collect(Collectors.toList());
        if(vehicleFilter.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }
        return vehicleFilter;
    }

    @Override
    public OptionalDouble findByBrandAverage(String brand){
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        List<Vehicle> vehicleFilter = vehicleList.stream().filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .toList();
        if(vehicleFilter.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }

        return vehicleFilter.stream().filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .mapToInt(Vehicle::getMax_speed).average();
    }

    @Override
    public String addMultipleVehicle(List<Vehicle> vehicleList){
        vehicleList.forEach(vehicle ->
                {if(vehicle == null) {
                    throw new BadSintaxisException("Datos de algún vehículo mal formados o incompletos.");
                }
                if(vehicleRepository.findById(vehicle.getId()) != null){
                    throw new VehicleExistsException("Algún vehículo tiene un identificador ya existente.");
                }});

        vehicleList.forEach(vehicle -> vehicleRepository.addVehicleAtList(vehicle));
        return "Vehículos creados exitosamente.";
    }

    @Override
    public String updateSpeed(Long id, int update_speed){
        if(update_speed < 0 || update_speed > 3000)
        {
            throw new BadSintaxisException("Velocidad mal formada o fuera de rango.");
        }
        Vehicle vehicle = vehicleRepository.findById(id);
        if(vehicle == null){
            throw new NotFoundException("No se encontró el vehículo.");
        }
        vehicle.setMax_speed(update_speed);
        return "Velocidad del vehículo actualizada exitosamente";
    }

    @Override
    public List<Vehicle> findByFuelType(String type) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        List<Vehicle> vehicleFilter = vehicleList.stream().filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(type)).toList();
        if (vehicleFilter.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }
        return vehicleFilter;
    }

    @Override
    public String deleteVehicle(Long id){
        Vehicle vehicle = vehicleRepository.findById(id);
        if(vehicle == null){
            throw new NotFoundException("No se encontró el vehículo");
        }
        vehicleRepository.delete(vehicle);
        return "Vehículo eliminado exitosamente.";
    }

    @Override
    public List<Vehicle> findByType(String type){
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        List<Vehicle> vehicleFilter = vehicleList.stream().filter(vehicle -> vehicle.getTransmission().equalsIgnoreCase(type)).toList();
        if(vehicleFilter.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión.");
        }
        return vehicleFilter;
    }

    @Override
    public String updateFuelType(Long id, String update_fuel){
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        Vehicle vehicles = vehicleList.stream().filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(update_fuel)).findFirst().orElse(null);
        if(update_fuel.isEmpty() || vehicles == null)
        {
            throw new BadSintaxisException("Tipo de Combustible mal formado o no admitido.");
        }
        Vehicle vehicle = vehicleRepository.findById(id);
        if(vehicle == null){
            throw new NotFoundException("No se encontró el vehículo.");
        }
        vehicle.setFuel_type(update_fuel);
        return "Tipo de combustible del vehículo actualizada exitosamente";
    }

    @Override
    public OptionalDouble findByCapacityAverage(String brand){
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        List<Vehicle> vehicleFilter = vehicleList.stream().filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .toList();
        if(vehicleFilter.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }

        return vehicleFilter.stream().filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .mapToInt(Vehicle::getPassengers).average();
    }

    @Override
    public List<VehicleDimenDto> findByDimension(double min_length, double max_length, double min_width, double max_width){

        List<Vehicle> vehicleList = vehicleRepository.findAll();
        List<Vehicle> vehicleFilter = vehicleList.stream().filter(vehicle -> vehicle.getHeight() > min_length && vehicle.getHeight() < max_length)
                .filter(vehicle -> vehicle.getWidth() > min_width && vehicle.getWidth() < max_width).toList();

        if(vehicleFilter.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }
        return vehicleFilter.stream().map(vehicle -> new VehicleDimenDto(vehicle.getId(),
                vehicle.getBrand(), vehicle.getModel(), vehicle.getHeight(), vehicle.getWidth())).collect(Collectors.toList());
    }

    @Override
    public List<VehicleWeightDto> findByWeight(double weight_min, double weight_max){
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        List<Vehicle> vehicleFilter = vehicleList.stream().filter(vehicle -> vehicle.getWeight() > weight_min
        && vehicle.getWeight() < weight_max).toList();

        if(vehicleFilter.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }

        return vehicleFilter.stream().map(vehicle -> new VehicleWeightDto(vehicle.getId(),
                vehicle.getBrand(), vehicle.getModel(), vehicle.getWeight())).collect(Collectors.toList());

    }

}
