package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.response.VehicleResponseDTO;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;

import com.bootcampW22.EjercicioGlobal.exception.CreatedException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.MapperUtils;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

    private final MapperUtils mapperUtils = new MapperUtils();

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {

        List<VehicleDto> vehicleList = mapperUtils.mapperToDtoList(vehicleRepository.findAll());

        if(vehicleList.isEmpty()){
            throw new NotFoundException();
        }
        return vehicleList;
    }

    @Override
    public VehicleResponseDTO addVehicles(VehicleDto vehicleDto) {

        if (vehicleDto.getId() == null || !isVehicleOk(vehicleDto)) {
            throw new BadRequestException();
        }

        if(vehicleRepository.thereIsAVehicleWithId(vehicleDto.getId())){
            throw new ConflictException();
        }

        Vehicle vehicleAdded = mapperUtils.mapperToEntity(vehicleDto);

        if (!vehicleRepository.addVehicles(vehicleAdded)) {
            throw new ConflictException();
        }
        return new VehicleResponseDTO("Vehicle whith id: " + vehicleAdded.getId() + " was added");
    }

    @Override
    public List<VehicleDto> searchVehicleByColorAndYear(String color, int year) {

        if (color == null || year < 0) {
            throw new BadRequestException();
        }
        // Corrección de code review el nombre del metodo mapperToDtoList de mi clase mapperUtils

        List<VehicleDto> vehicleDtos = mapperUtils.mapperToDtoList(vehicleRepository.findAll()).stream().filter(vehicleDto -> vehicleDto.getColor().equals(color) && vehicleDto.getYear() == year).toList();

        if(vehicleDtos.isEmpty()){
            throw new NotFoundException();
        }
        return vehicleDtos;
    }

    @Override
    public List<VehicleDto> searchByBrandAndYear(String brand, int starYear, int endYear) {

        List<VehicleDto> vehicleDtos = mapperUtils.mapperToDtoList(vehicleRepository.findAll());

        List<VehicleDto> vehicleByBrandAndYear = vehicleDtos.stream().filter(v -> v.getBrand().equals(brand) && (v.getYear() >= starYear && v.getYear() <= endYear)).toList();

        if(vehicleByBrandAndYear.isEmpty()){
            throw new NotFoundException();
        }
        return vehicleByBrandAndYear;
    }

    @Override
    public VehicleResponseDTO averageSpeedByBrand(String brand) {

        if (brand == null || brand.isEmpty()) {
            throw new BadRequestException();
        }

        List<VehicleDto> vehicleDtos = mapperUtils.mapperToDtoList(vehicleRepository.findAll());

        double average = vehicleDtos.stream().filter(v -> v.getBrand().equals(brand)).mapToDouble(v -> Double.parseDouble(v.getMax_speed())).average().orElseThrow(NotFoundException::new);

        return new VehicleResponseDTO("La marca: " + brand + "tiene un promedio de velocidad igual a: "+ average );
    }

    @Override
    public VehicleResponseDTO addListVehicles(List<VehicleDto> vehicleDtos) {

        if (vehicleDtos.isEmpty()) {
            throw new CreatedException();
        }

        List<Vehicle> vehicleList = mapperUtils.mapperToEntityList(vehicleDtos);

        boolean isIdExist = vehicleList.stream().anyMatch(v -> vehicleRepository.thereIsAVehicleWithId(v.getId()));

        if(isIdExist){
            throw new ConflictException();
        }

        vehicleList.forEach(v -> vehicleRepository.addVehicles(v));

        return new VehicleResponseDTO("Vehículos creados exitosamente.");
    }

    @Override
    public VehicleResponseDTO updateSpeed(Long id, Double updateSpeed) {

        Vehicle vehicle = vehicleRepository.findById(id);

        if (vehicle == null) {
            throw new NotFoundException();
        }

        if (updateSpeed < 1 || updateSpeed > 300) {
            throw new BadRequestException();
        }

        vehicle.setMax_speed(updateSpeed.toString());

        if (vehicleRepository.editVehicle(vehicle)) {
            throw new ConflictException();
        }
        return new VehicleResponseDTO("Vehículos actualizado correctamente.");
    }

    @Override
    public List<VehicleDto> searByFuelType(String type) {
        if (type == null || type.isEmpty()) {
            throw new BadRequestException();
        }
        List<Vehicle> vehicleEntites = vehicleRepository.findAll().stream().filter(v -> v.getFuel_type().equals(type)).toList();
        if(vehicleEntites.isEmpty()){
            throw new NotFoundException();
        }
        return mapperUtils.mapperToDtoList(vehicleEntites);
    }

    @Override
    public VehicleResponseDTO deleteById(Long id) {
        if(!vehicleRepository.thereIsAVehicleWithId(id)){
            throw new ConflictException();
        }
        if(!vehicleRepository.deleteById(id)){
            throw new NotFoundException();
        }
        return new VehicleResponseDTO("Se elimino con exito.");
    }

    @Override
    public List<VehicleDto> searchByTransmissionType(String type) {

        if (type == null || type.isEmpty()) {
            throw new BadRequestException();
        }

        List<Vehicle> vehiclesByTransmissionType = vehicleRepository.findAll().stream().filter(v -> v.getTransmission().equals(type)).toList();

        if(vehiclesByTransmissionType.isEmpty()){
            throw new NotFoundException();
        }
        return mapperUtils.mapperToDtoList(vehiclesByTransmissionType);
    }

    @Override
    public VehicleResponseDTO updateFuelById(Long id, String updateFuel) {

        if(id == null || updateFuel == null || updateFuel.isEmpty()) {
            throw new BadRequestException();
        }

        Vehicle vehicle = vehicleRepository.findById(id);

        if (vehicle == null) {
            throw new NotFoundException();
        }
        vehicle.setFuel_type(updateFuel);

        if (vehicleRepository.editVehicle(vehicle)) {
            throw new ConflictException();
        }
        return new VehicleResponseDTO("Vehículos actualizado correctamente.");
    }

    @Override
    public VehicleResponseDTO averageCapacityByBrand(String brand) {

        if (brand == null || brand.isEmpty()) {
            throw new BadRequestException();
        }

        List<VehicleDto> vehicleDtos = mapperUtils.mapperToDtoList(vehicleRepository.findAll());

        double promedio = vehicleDtos.stream().filter(v -> v.getBrand().equals(brand))
                .mapToInt(VehicleDto::getPassengers).average().orElseThrow(NotFoundException::new);

        return new VehicleResponseDTO("La marca: " + brand + "tiene un promedio de capacidad de personas igual a: " + promedio);
    }

    @Override
    public List<VehicleDto> getByRangeWeight(Double weightMin, Double weightMax) {

        if (weightMin == null || weightMax == null) {
            throw new BadRequestException();
        }

        List<Vehicle> vehicleList = vehicleRepository.findAll().stream().filter(vehicle -> vehicle.getWeight() > weightMin && vehicle.getWeight() < weightMax).toList();

        if (vehicleList.isEmpty()) {
            throw new NotFoundException();
        }
        return mapperUtils.mapperToDtoList(vehicleList);
    }

    @Override
    public List<VehicleDto> getVehiclesByDimension(String lengthValue, String width) {
        String[] lengthSplit = lengthValue.split("-");
        double minLength = Double.parseDouble(lengthSplit[0]);
        double maxLength = Double.parseDouble(lengthSplit[1]);

        String[] widthSplit = width.split("-");
        double minWide = Double.parseDouble(widthSplit[0]);
        double maxWide = Double.parseDouble(widthSplit[1]);

        List<Vehicle> vehicleList = vehicleRepository.findAll().stream()
                .filter(vehicle -> (( vehicle.getHeight() > minLength && vehicle.getHeight() < maxLength)
                        && (vehicle.getWidth() > minWide && vehicle.getWidth() < maxWide))).toList();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException();
        }
        return mapperUtils.mapperToDtoList(vehicleList);
    }

    private boolean isVehicleOk(VehicleDto vehicleDto) {
        return vehicleDto.getId() != null && vehicleDto.getId() >= 0;
    }
}
