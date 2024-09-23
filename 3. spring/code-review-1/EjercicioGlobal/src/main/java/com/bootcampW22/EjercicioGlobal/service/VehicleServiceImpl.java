package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.DimensionParseException;
import com.bootcampW22.EjercicioGlobal.exception.ExistingIdException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.ValidationException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.VehicleValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VehicleServiceImpl implements IVehicleService{
    private final IVehicleRepository vehicleRepository;
    private final VehicleValidator vehicleValidator;
    private final ObjectMapper mapper;

    public VehicleServiceImpl(IVehicleRepository vehicleRepository, VehicleValidator vehicleValidator){
        this.vehicleRepository = vehicleRepository;
        this.vehicleValidator = vehicleValidator;
        this.mapper = new ObjectMapper();
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
    public void create(VehicleDto vehicleDto) {
        vehicleValidator.validate(vehicleDto);

        if (vehicleRepository.exists(vehicleDto.getId())) {
            throw new ExistingIdException("Identificador del vehículo ya existente.");
        }

        Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
        vehicleRepository.save(vehicle);
    }

    @Override
    public List<VehicleDto> getVehiclesByColorAndYear(String color, Integer year) {
        Stream<Vehicle> vehiclesStream = vehicleRepository.findAll().stream();

        if (color != null) {
            vehiclesStream = vehiclesStream.filter(v -> v.getColor().equalsIgnoreCase(color));
        }

        if (year != null) {
            vehiclesStream = vehiclesStream.filter(v -> v.getYear() == year);
        }

        List<Vehicle> vehicles = vehiclesStream.toList();

        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }

        return vehicles.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public List<VehicleDto> getByBrandAndYearRange(String brand, Integer startYear, Integer endYear) {
        if (startYear > endYear) {
            throw new ValidationException("El año de comienzo no puede ser posterior al de finalización del período.");
        }

        List<VehicleDto> vehicles = vehicleRepository.findAll().stream()
                .filter(vehicle ->
                        vehicle.getBrand().equalsIgnoreCase(brand) &&
                                vehicle.getYear() >= startYear && vehicle.getYear() <= endYear)
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .toList();

        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }

        return vehicles;
    }

    @Override
    public double getAverageSpeed(String brand) {
        List<Vehicle> vehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .toList();

        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }

        return vehicles.stream()
                .mapToDouble(v -> Double.parseDouble(v.getMax_speed()))
                .average().orElse(0.0);
    }

    @Override
    public void create(List<VehicleDto> vehicleDtos) {
        try {
            vehicleDtos.forEach(vehicleValidator::validate);
        } catch (ValidationException e) {
            throw new ValidationException("Datos de algún vehículo mal formados o incompletos.");
        }

        List<Long> repeatedIds = vehicleDtos.stream()
                .map(VehicleDto::getId)
                .filter(vehicleRepository::exists)
                .toList();

        if (!repeatedIds.isEmpty()) {
            throw new ExistingIdException("Algún vehículo tiene un identificador ya existente.");
        }

        vehicleRepository.save(vehicleDtos.stream().map(v -> mapper.convertValue(v, Vehicle.class)).toList());
    }

    @Override
    public void updateSpeed(Long id, String newSpeed) {
        if (Double.parseDouble(newSpeed) < 0) {
            throw new ValidationException("Velocidad mal formada o fuera de rango.");
        }

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el vehículo."));
        vehicle.setMax_speed(newSpeed);

        vehicleRepository.update(vehicle);
    }

    @Override
    public List<VehicleDto> getByDimensions(String length, String width) {
        double minLength;
        double maxLength;
        double minWidth;
        double maxWidth;

        try {
            minLength = Double.parseDouble(length.split("-")[0]);
            maxLength = Double.parseDouble(length.split("-")[0]);
            minWidth = Double.parseDouble(length.split("-")[0]);
            maxWidth = Double.parseDouble(length.split("-")[0]);

        } catch (Exception e) {
            throw new DimensionParseException("Could not parse values length (%s) or width (%s). Make sure they are structured in a min-max format."
                    .formatted(length, width));
        }

        if (minLength > maxLength || minWidth > maxWidth) {
            throw new ValidationException("max values must be greater than or equal to min values.");
        }

        List<VehicleDto> vehicles = vehicleRepository.findAll().stream()
                .filter(v -> v.getHeight() >= minLength)
                .filter(v -> v.getHeight() <= maxLength)
                .filter(v -> v.getWidth() >= minWidth)
                .filter(v -> v.getWidth() <= maxWidth)
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();

        if (vehicles.isEmpty()) {
            throw new NotFoundException("No vehicles were found with the requested parameters.");
        }

        return vehicles;
    }

    @Override
    public List<VehicleDto> getByWeightRange(Double minWeight, Double maxWeight) {
        if (minWeight > maxWeight) {
            throw new ValidationException("max values must be greater than or equal to min values.");
        }

        List<VehicleDto> vehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getWeight() >= minWeight && vehicle.getWeight() <= maxWeight)
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .toList();

        if (vehicles.isEmpty()) {
            throw new NotFoundException("No vehicles were found with the requested parameters.");
        }

        return vehicles;
    }

    @Override
    public List<VehicleDto> getByFuelType(String fuelType) {
        List<VehicleDto> vehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(fuelType))
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .toList();

        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }

        return vehicles;
    }

    @Override
    public void delete(Long id) {
        if (!vehicleRepository.exists(id)) {
            throw new NotFoundException("No se encontró el vehículo.");
        }

        vehicleRepository.delete(id);
    }

    @Override
    public List<VehicleDto> getByTransmission(String transmission) {
        List<VehicleDto> vehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getTransmission().equalsIgnoreCase(transmission))
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .toList();

        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión.");
        }

        return vehicles;
    }

    @Override
    public void updateFuelType(Long id, String newFuelType) {
        List<String> allowedFuelTypes = List.of("gasoline", "diesel", "biodiesel", "gas");

        if (!allowedFuelTypes.contains(newFuelType.toLowerCase())) {
            throw new ValidationException("Tipo de combustible mal formado o no admitido.");
        }

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el vehículo."));
        vehicle.setFuel_type(newFuelType);

        vehicleRepository.update(vehicle);
    }

    @Override
    public Double getAverageCapacity(String brand) {
        List<Vehicle> vehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .toList();

        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }

        return vehicles.stream()
                .mapToInt(Vehicle::getPassengers)
                .average().orElse(0.0);
    }
}
