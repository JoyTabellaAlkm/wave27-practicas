package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.request.VehicleUpdateDTO;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.InvalidVehicleException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleAlreadyExistException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void saveVehicle(Vehicle vehicle){

        if (!validateVehicle(vehicle)){
            throw new InvalidVehicleException("Invalid Data or incomplete");
        }

        if (vehicleRepository.idExist(vehicle.getId())){
            throw new VehicleAlreadyExistException(
                    String.format("There is already a vehicle with ID = %d", vehicle.getId()));
        }

        vehicleRepository.saveVehicle(vehicle);

    }

    @Override
    public List<Vehicle> getVehicleByColorAndYear(String color, Integer year){

        List<Vehicle> filteredList = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getColor().equals(color))
                .filter(vehicle -> vehicle.getYear() == year)
                .toList();

        if (filteredList.isEmpty()){
            throw new NotFoundException(String.format("There is no vehicle with color = %s and year = %d", color, year));
        }

        return filteredList;
    }

    @Override
    public List<Vehicle> getVehicleByBrandAndYears(String brand, Integer startYear, Integer endYear){

        List<Vehicle> filteredList = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .filter(vehicle -> vehicle.getYear() >= startYear &&
                        vehicle.getYear() <= endYear)
                .toList();

        if (filteredList.isEmpty()){
            throw new NotFoundException(String.format
                    ("There is no vehicle with brand = %s and between years = %d - %d", brand, startYear, endYear));
        }

        return filteredList;
    }

    @Override
    public Double getAverageSpeedByBrand(String brand){

        List<Vehicle> filteredList = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .toList();

        if (filteredList.isEmpty()){
            throw new NotFoundException(String.format("There is no vehicle with brand = %s", brand));
        }

        return filteredList.stream()
                .mapToDouble(vehicle -> Double.parseDouble(vehicle.getMax_speed()))
                .average()
                .orElse(0);
    }

    @Override
    public void updateVehicleSpeed(Long id, VehicleUpdateDTO vehicleUpdateDTO){

        if (!vehicleRepository.idExist(id)){
            throw new NotFoundException(String.format("There is no vehicle with ID = %d", id));
        }

        if (!validateSpeedUpdate(vehicleUpdateDTO)){
            throw new InvalidVehicleException("Invalid speed");
        }

        vehicleRepository.updateSpeed(id, vehicleUpdateDTO.getSpeed());
    }

    @Override
    public List<Vehicle> getVehicleByFuel(String fuel){

        List<Vehicle> filteredList = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getFuel_type().equals(fuel))
                .toList();

        if (filteredList.isEmpty()){
            throw new NotFoundException(String.format("There is no vehicle with fuel type = %s", fuel));
        }

        return filteredList;
    }

    @Override
    public void deleteVehicle(Long id) {

        if (!vehicleRepository.idExist(id)){
            throw new NotFoundException(String.format("There is no vehicle with ID = %d", id));
        }

        vehicleRepository.deleteVehicle(vehicleRepository.getVehicleById(id));

    }

    @Override
    public void updateFuel(Long id, VehicleUpdateDTO vehicle) {

        if (!vehicleRepository.idExist(id)){
            throw new NotFoundException(String.format("There is no vehicle with ID = %d", id));
        }

        vehicleRepository.updateFuel(id, vehicle.getFuelType());
    }

    @Override
    public Double getBrandAveragePassangers(String brand) {

        List<Vehicle> filteredList = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .toList();

        if (filteredList.isEmpty()){
            throw new NotFoundException(String.format("There is no vehicle with brand = %s", brand));
        }

        return filteredList.stream()
                .mapToDouble(Vehicle::getPassengers)
                .average()
                .orElse(0);
    }

    @Override
    public List<Vehicle> getVehiclesByDimension(String length, String width) {

        Integer minLength;
        Integer maxLength;
        Integer minWidth;
        Integer maxWidth;

        if (length != null) {
            String[] lengthParts = length.split("-");
            minLength = Integer.parseInt(lengthParts[0]);
            maxLength = Integer.parseInt(lengthParts[1]);
        } else {
            maxLength = null;
            minLength = null;
        }

        if (width != null){
            String[] widthParts = width.split("-");
            minWidth = Integer.parseInt(widthParts[0]);
            maxWidth = Integer.parseInt(widthParts[1]);
        } else {
            maxWidth = null;
            minWidth = null;
        }

        List<Vehicle> filteredList = vehicleRepository.findAll().stream()
                .filter(vehicle -> (minLength == null || (vehicle.getHeight() >= minLength && vehicle.getHeight() <= maxLength)))
                .filter(vehicle -> (minWidth == null || (vehicle.getWidth() >= minWidth && vehicle.getWidth() <= maxWidth)))
                .toList();

        if (filteredList.isEmpty()){
            throw new NotFoundException("There is no vehicle with that dimensions");
        }

        return filteredList;
    }

    @Override
    public List<Vehicle> getVehiclesByWeight(Integer weightMin, Integer weightMax) {

        List<Vehicle> filteredList = vehicleRepository.findAll().stream()
                .filter(vehicle -> (weightMin == null || weightMin <= vehicle.getWeight()))
                .filter(vehicle -> (weightMax == null || weightMax >= vehicle.getWeight()))
                .toList();

        if (filteredList.isEmpty()){
            throw new NotFoundException("There is no vehicle with that weight");
        }

        return filteredList;
    }

    private Boolean validateSpeedUpdate(VehicleUpdateDTO vehicle){

        if (vehicle.getSpeed() == null || Double.parseDouble(vehicle.getSpeed()) <= 0
                || Double.parseDouble(vehicle.getSpeed()) >= 400){
            return false;
        }
        return true;
    }

    private Boolean validateVehicle(Vehicle vehicle){
        if (vehicle.getId() == null){
            return false;
        }
        if (vehicle.getBrand() == null){
            return false;
        }
        if (vehicle.getModel() == null){
            return false;
        }
        return true;
    }
}
