package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.AlreadyExistException;
import com.bootcampW22.EjercicioGlobal.exception.InvalidVehicleException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String addVehicle(VehicleDto vehicleDto) {
        String msg = "Vehículo creado exitosamente.";

        if (vehicleDto == null || !isValid(vehicleDto)) {
            throw new InvalidVehicleException("Datos del vehículo mal formados o incompletos.");
        }

        if (vehicleRepository.existVehicle(vehicleDto.getId())) {
            throw new AlreadyExistException("Identificador del vehículo ya existente.");
        }
        vehicleRepository.addVehicle(mapperToEntity(vehicleDto));
        return msg;
    }

    @Override
    public List<VehicleDto> searchByColorYear(String color, Integer year) {
        List<VehicleDto> listVehicleDto = mapperToDtoList(vehicleRepository.findAll());
        List<VehicleDto> listFiltered = listVehicleDto.stream().filter(v -> v.getColor().equals(color) && v.getYear() == year).toList();
        if (listFiltered.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }

        return listFiltered;
    }

    @Override
    public List<VehicleDto> searchByBrandYear(String brand, Integer startYear, Integer endYear) {
        List<VehicleDto> listVehicleDto = mapperToDtoList(vehicleRepository.findAll());
        List<VehicleDto> listFiltered = listVehicleDto.stream().filter(v -> v.getBrand().equals(brand) && v.getYear() >= startYear && v.getYear() <= endYear).toList();
        if (listFiltered.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }

        return listFiltered;
    }

    @Override
    public Double getAverageByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        return vehicleList.stream()
                .filter(v -> v.getBrand().equals(brand))
                .mapToDouble(v -> parseToDouble(v.getMax_speed())).average().orElseThrow(() -> new NotFoundException("No se encontraron vehículos de esa marca."));
    }

    @Override
    public String addMultipleVehicles(List<VehicleDto> listVehicleDto) {
        String msg = "Vehículos creados exitosamente.";

        if (listVehicleDto.isEmpty()) {
            throw new InvalidVehicleException("Datos de algún vehículo mal formados o incompletos.");
        }
        boolean value = listVehicleDto.stream().anyMatch(v -> vehicleRepository.existVehicle(v.getId()));

        if (value) {
            throw new AlreadyExistException("Algún vehículo tiene un identificador ya existente.");
        }


        List<Vehicle> listVehicle = mapperToEntityList(listVehicleDto);

        listVehicle.forEach(v -> vehicleRepository.addVehicle(v));
        return msg;
    }

    @Override
    public String editSpeed(Long id, Double speed) {
        String msg = "Velocidad del vehículo actualizada exitosamente.";
        Vehicle vehicle = vehicleRepository.getById(id);

        if (vehicle == null) {
            throw new NotFoundException("No se encontró el vehículo.");
        }
        if (speed < 1 || speed > 300) {
            throw new InvalidVehicleException("Velocidad mal formada o fuera de rango.");
        }

        vehicle.setMax_speed(speed.toString());
        boolean value = vehicleRepository.editVehicle(vehicle);
        if (!value) {
            msg = "No se pudo editar el vehiculo";
        }

        return msg;
    }

    @Override
    public List<VehicleDto> getVehiclesByFuel(String type) {
        List<Vehicle> listVehicle = vehicleRepository.findAll().stream().filter(vehicle -> vehicle.getFuel_type().equals(type)).toList();

        if (listVehicle.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }
        return mapperToDtoList(listVehicle);
    }

    @Override
    public String deleteVehicle(Long id) {
        String msg = "Vehículo eliminado exitosamente.";
        boolean value = vehicleRepository.existVehicle(id);

        if (!value) {
            throw new NotFoundException("No se encontró el vehículo.");
        }

        Vehicle vehicle = vehicleRepository.getById(id);
        if (!vehicleRepository.deleteVehicle(vehicle)) {
            msg = "No se pudo eliminar el vehiculo";
        }

        return msg;
    }

    @Override
    public List<VehicleDto> getVehiclesByTransmission(String type) {
        List<Vehicle> listVehicle = vehicleRepository.findAll().stream()
                .filter(v -> v.getTransmission().equals(type)).toList();

        if (listVehicle.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión.");
        }
        return mapperToDtoList(listVehicle);
    }

    @Override
    public String editFuel(Long id, String fuel) {
        String msg = "Tipo de combustible del vehículo actualizado exitosamente.";
        boolean value = vehicleRepository.existVehicle(id);
        if (!value) {
            throw new NotFoundException("No se encontró el vehículo.");
        }

        if (fuel.isBlank() || !fuel.matches("[0-9]")) {
            throw new InvalidVehicleException("Tipo de combustible mal formado o no admitido.");
        }

        Vehicle vehicle = vehicleRepository.getById(id);
        vehicle.setFuel_type(fuel);
        vehicleRepository.editVehicle(vehicle);

        return msg;
    }

    @Override
    public Double getAverageCapacityByBrand(String brand) {
        return vehicleRepository.findAll().stream()
                .filter(v -> v.getBrand().equals(brand))
                .mapToInt(Vehicle::getPassengers)
                .average()
                .orElseThrow(() -> new NotFoundException("No se encontraron vehículos de esa marca."));
    }

    @Override
    public List<VehicleDto> getVehiclesByDimension(String lengthValue, String width) {
        String[] lengthSplit = lengthValue.split("-");
        Double minLength = parseToDouble(lengthSplit[0]);
        Double maxLength = parseToDouble(lengthSplit[1]);

        String[] widthSplit = width.split("-");
        Double minWide = parseToDouble(widthSplit[0]);
        Double maxWide = parseToDouble(widthSplit[1]);

        List<Vehicle> vehicleList = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getHeight() > minLength && vehicle.getHeight() < maxLength
                        && vehicle.getWidth() > minWide && vehicle.getWidth() < maxWide).toList();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones.");
        }
        return mapperToDtoList(vehicleList);
    }

    @Override
    public List<VehicleDto> getByRangeWeight(Double weightMin, Double weightMax) {
        List<Vehicle> vehicleList = vehicleRepository.findAll().stream().filter(vehicle -> vehicle.getWeight() > weightMin && vehicle.getWeight() < weightMax).toList();

        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos en ese rango de peso.");
        }

        return mapperToDtoList(vehicleList);
    }


// ======================== AUXILIARY METHODS ========================

    private Double parseToDouble(String value) {
        double valueResponse = 0.0;
        try {
            valueResponse = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            valueResponse = 0.0;
        } finally {
            return valueResponse;
        }
    }

    private Boolean isValid(VehicleDto vehicleDto) {
        boolean msg = true;
        if (vehicleDto.getId() == null || vehicleDto.getId() < 0) {
            msg = false;
        }

        return msg;
    }

    private Vehicle mapperToEntity(VehicleDto vehicleDto) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(vehicleDto, Vehicle.class);
    }

    private VehicleDto mapperToDto(Vehicle vehicle) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(vehicle, VehicleDto.class);
    }

    private List<VehicleDto> mapperToDtoList(List<Vehicle> listVehicle) {
        ModelMapper modelMapper = new ModelMapper();

        //return modelMapper.map(listVehicle, new TypeToken<List<Vehicle>>() {}.getType());
        return listVehicle.stream().map(v -> modelMapper.map(v, VehicleDto.class)).toList();
    }

    private List<Vehicle> mapperToEntityList(List<VehicleDto> listVehicleDto) {
        ModelMapper modelMapper = new ModelMapper();

        //return modelMapper.map(listVehicle, new TypeToken<List<Vehicle>>() {}.getType());
        return listVehicleDto.stream().map(v -> modelMapper.map(v, Vehicle.class)).toList();
    }
}
