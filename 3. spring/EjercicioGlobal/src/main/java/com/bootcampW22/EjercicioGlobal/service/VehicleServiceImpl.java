package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.component.VehicleValidator;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.*;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class VehicleServiceImpl implements IVehicleService{

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 1;
    IVehicleRepository vehicleRepository;
    private VehicleValidator vehicleValidator = new VehicleValidator();


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
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        List<String> missingData = vehicleValidator.validateVehicle(vehicleDto);

        if (!missingData.isEmpty()) {
            throw new IncompleteVehicleDataException(missingData);
        }

        if (idExist(vehicleDto.getId())) {
            throw new CarAlreadyExistException("Ya existe un vehiculo con este identificador " + vehicleDto.getId());
        }

        Vehicle newVehicle = mapToVehicle(vehicleDto);
        vehicleRepository.save(newVehicle);
        return vehicleDto;
    }

    @Override
    public double findAverageSpeed(String brand) {
        List<Vehicle> filteredVehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .toList();

        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehiculos de esta marca");
        }

        return filteredVehicles.stream()
                .mapToInt(vehicle -> Integer.parseInt(vehicle.getMax_speed()))
                .average()
                .getAsDouble();
    }

    @Override
    public List<VehicleDto> findByColorAndYear(String color, int year) {
        List<Vehicle> vehiclesFiltered = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getYear() == year)
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());

        if (vehiclesFiltered.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con estos criterios");
        }

        return vehiclesFiltered.stream()
                .map(car -> mapToDto(car))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> saveVehicles(List<VehicleDto> vehicles) {
        List<String> missingDataError = vehicles.stream()
                .flatMap(vehicle -> vehicleValidator.validateVehicle(vehicle).stream())
                        .collect(Collectors.toList());

        if (!missingDataError.isEmpty()) {
            throw new IncompleteVehicleDataException(missingDataError);
        }

        if (vehicles.stream().anyMatch(v -> idExist(v.getId()))) {
            throw new CarAlreadyExistException("Algun vehiculo tiene un identificador existente");
        }

        List<Vehicle> vehiclesMaped = vehicles.stream().map(v -> mapToVehicle(v)).toList();
        vehicleRepository.saveAll(vehiclesMaped);

        return vehicles;
    }

    @Override
    public VehicleDto updateMaxSpeed(Long id, String maxSpeed) {
        if (!idExist(id)) {
            throw new NotFoundException("No existe un vehiculo con este identificador");
        }

        if (!vehicleValidator.validateSpeed(maxSpeed)) {
            throw new MaxSpeedOutOfRangeException("La velocidad está fuera de rango aceptado");
        }

        return mapToDto(vehicleRepository.updateMaxSpeed(id, maxSpeed));
    }

    @Override
    public List<VehicleDto> findVehiclesByFuelType(String type) {
        List<Vehicle> filteredVehicles = vehicleRepository.findAll()
                .stream()
                .filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(type))
                .collect(Collectors.toList());

        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No hay vehiculos con estos criterios");
        }

        return filteredVehicles.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto deleteVehicleById(Long id) {

        if(!idExist(id)) {
            throw new NotFoundException("No hay un vehiculo con ese id");
        }

        Vehicle vehicle = vehicleRepository.findAll()
                .stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);

        VehicleDto vehicleDto = mapToDto(vehicle);
        vehicleRepository.deleteVehicle(vehicle);

        return vehicleDto;
    }

    @Override
    public List<VehicleDto> findByTransmission(String type) {
        List<Vehicle> filteredVehicles = vehicleRepository.findAll().stream()
                .filter(v -> v.getTransmission().equals(type))
                .collect(Collectors.toList());

        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No hay vehiculos con esos criterios");
        }

        return filteredVehicles.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto updateFuel(Long id, String type) {

        if (!idExist(id)) {
            throw new NotFoundException("No existe un vehiculo con ese id");
        }

        if (!vehicleValidator.validateFuel(type)) {
            throw new IncompleteFuelException("El tipo de combustible debe estar completo");
        }

        return mapToDto(vehicleRepository.updateFuel(id, type));
    }

    @Override
    public double calculateCapacityByBrand(String brand) {
        List<Vehicle> filteredVehicles = vehicleRepository.findAll()
                .stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());

        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No hay vehiculos con esos criterios");
        }

        return filteredVehicles.stream()
                .mapToInt(Vehicle::getPassengers)
                .average()
                .orElse(0.0);
    }

    @Override
    public List<VehicleDto> findVehiclesByDimensions(String length, String width) {
        double[] lengthValues = getMinAndMax(length);
        double[] widthValues = getMinAndMax(width);

        double minLength = lengthValues[MIN_VALUE];
        double maxLength = lengthValues[MAX_VALUE];
        double minWidth = widthValues[MIN_VALUE];
        double maxWidth = widthValues[MAX_VALUE];

        List<Vehicle> filteredVehicles = vehicleRepository.findAll().stream()
                .filter(v -> (v.getHeight() >= minLength && v.getHeight() <= maxLength) &&
                       (v.getWidth() >= minWidth && v.getWidth() <= maxWidth))
                .collect(Collectors.toList());

        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No hay vehiculos con estos criterios");
        }

        return filteredVehicles.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findVehiclesByWeigth(String min, String max) {
        double minWeigth = Double.parseDouble(min);
        double maxWeigth = Double.parseDouble(max);

        List<Vehicle> filteredVehicles = vehicleRepository.findAll()
                .stream()
                .filter(v -> v.getWeight() >= minWeigth && v.getWeight() <= maxWeigth)
                .collect(Collectors.toList());

        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No hay vehiculos con este criterio");
        }

        return filteredVehicles.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private double[] getMinAndMax(String value) {
        String[] values = value.split("-");
        double[] res = {0, 0};

        res[MIN_VALUE] = Double.parseDouble(values[MIN_VALUE]);
        res[MAX_VALUE] = Double.parseDouble(values[MAX_VALUE]);

        return res;
    }

    private Vehicle mapToVehicle(VehicleDto vehicleDto) {
        return new Vehicle(vehicleDto.getId(), vehicleDto.getBrand(), vehicleDto.getModel(), vehicleDto.getRegistration(),
                vehicleDto.getColor(), vehicleDto.getYear(), vehicleDto.getMax_speed(), vehicleDto.getPassengers(),
                vehicleDto.getFuel_type(), vehicleDto.getTransmission(), vehicleDto.getHeight(), vehicleDto.getWidth(),
                vehicleDto.getWeight());
    }

    private VehicleDto mapToDto(Vehicle vehicle) {
        return new VehicleDto(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getRegistration(),
                vehicle.getColor(), vehicle.getYear(), vehicle.getMax_speed(), vehicle.getPassengers(),
                vehicle.getFuel_type(), vehicle.getTransmission(), vehicle.getHeight(), vehicle.getWidth(),
                vehicle.getWeight());
    }

    private boolean idExist(Long id) {
        return vehicleRepository.findAll().stream().anyMatch(v -> v.getId().equals(id));
    }
}
