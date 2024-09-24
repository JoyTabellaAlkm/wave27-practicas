package com.bootcampW22.EjercicioGlobal.service.impl;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.impl.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;

@Service
public class VehicleServiceImpl implements IVehicleService {


    IVehicleRepository vehicleRepository;
    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
           // throw new NotFoundException("No se encontró ningun auto en el sistema.");
            throw new NotFoundException("No hay vehículos en la concesionaria");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String addVehicle(VehicleDto vehicle) {
        if(vehicle ==null ){
            throw new BadRequestException("Datos del vehículo mal formados o incompletos.");
        }

        if (vehicle.getId() == null ||
                vehicle.getBrand() == null ||
                vehicle.getModel() == null ||
                vehicle.getRegistration() == null ||
                vehicle.getColor() == null ||
                vehicle.getYear() == 0 ||
                vehicle.getMax_speed() == null ||
                vehicle.getPassengers() == 0 ||
                vehicle.getFuel_type() == null ||
                vehicle.getTransmission() == null ||
                vehicle.getHeight() == 0 ||
                vehicle.getWidth() == 0 ||
                vehicle.getWeight() == 0){
            throw new BadRequestException("Datos del vehículo mal formados o incompletos.");
        }

        List<Vehicle> vehicleList= vehicleRepository.findAll().stream().filter(v->v.getId().equals(vehicle.getId())).toList();
        if(!vehicleList.isEmpty())
        {
            throw new ConflictException("Identificador del vehículo ya existente");
        }

        ObjectMapper mapper= new ObjectMapper();
        Vehicle vehiculoMapeado= mapper.convertValue(vehicle, Vehicle.class);
        vehicleRepository.addVehicle(vehiculoMapeado);

        return "Vehículo creado exitosamente.";
    }


    @Override
    public List<VehicleDto> searchByColorAndYear(String color, int year) {
        List<VehicleDto> search= searchAllVehicles().stream().filter(v->v.getColor().equals(color) && v.getYear()==year).toList();

        if (search.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }
        return searchAllVehicles().stream().filter(v->v.getColor().equalsIgnoreCase(color) && v.getYear()==year).toList();
    }


    @Override
    public List<VehicleDto> seachByBrandAndYears(String brand, int yearInit, int yearEnd) {
        List<VehicleDto> search=  searchAllVehicles().stream().filter(v->v.getBrand().equalsIgnoreCase(brand) &&  v.getYear()>=yearInit && v.getYear()<=yearEnd ).toList();
        if(search.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }
        return search;
    }

    @Override
    public Double averageSpeed(String brand) {
        Boolean existe= vehicleRepository.findAll().stream().anyMatch(v->v.getBrand().equalsIgnoreCase(brand));
        if(existe){

            return vehicleRepository.findAll()
                    .stream()
                    .filter(v->v.getBrand().equalsIgnoreCase(brand))
                    .mapToDouble(v->parseDouble(v.getMax_speed()))
                    .average()
                    .orElseThrow(()->new BadRequestException("No se pudo realizar el promedio"));}
        else{
            throw new NotFoundException("No se encontraron vehículos de esta marca");
        }
    }

    @Override
    public String addMultipleVehicles(List<VehicleDto> listaOfVehicles) {

    boolean hayNulo= listaOfVehicles.stream().anyMatch(Objects::isNull);
    if(hayNulo)
    {
        throw new BadRequestException("Datos de algún vehículo mal formados o incompletos.");
    }

    boolean parametrosNulos = listaOfVehicles.stream().anyMatch(v ->
                v.getBrand() == null ||
                        v.getModel() == null ||
                        v.getRegistration() == null ||
                        v.getColor() == null ||
                        v.getYear() == 0 ||
                        v.getMax_speed() == null ||
                        v.getPassengers() == 0 ||
                        v.getFuel_type() == null ||
                        v.getTransmission() == null ||
                        v.getHeight() == 0 ||
                        v.getWidth() == 0 ||
                        v.getWeight() == 0);

    if (parametrosNulos) {
            throw new BadRequestException("Datos de algún vehículo mal formados o incompletos.");
    }

        List<Long> id = vehicleRepository.findAll().stream().map(Vehicle::getId).toList();
        boolean existe = listaOfVehicles.stream().map(VehicleDto::getId).anyMatch(id::contains);

        if (existe) {

            throw new ConflictException("Algún vehículo tiene un identificador ya existente");
        }
        listaOfVehicles.forEach(v -> {
            Vehicle vehicle = new Vehicle(v.getId(),
                    v.getBrand(),
                    v.getModel(),
                    v.getRegistration(),
                    v.getColor(),
                    v.getYear(),
                    v.getMax_speed(),
                    v.getPassengers(),
                    v.getFuel_type(),
                    v.getTransmission(),
                    v.getHeight(),
                    v.getWidth(),
                    v.getWeight());
            vehicleRepository.addVehicle(vehicle);
        });
        return "Vehículos creados exitosamente";
    }


    @Override
    public String updateSpeed(Integer id, Integer velocidad) {

        if(velocidad==null || velocidad <= 0){
            throw new BadRequestException("Velocidad mal formada o fuera de rango.");
        }

        Vehicle vehicleChange= vehicleRepository.findAll()
                .stream()
                .filter(v->v.getId().equals(id.longValue()))
                .findFirst()
                .orElseThrow(()-> new NotFoundException("No se encontró el vehículo"));

        vehicleChange.setMax_speed(String.valueOf(velocidad));
        return "Velocidad del vehículo actualizada exitosamente.";
    }

    @Override
    public String deleteVehicle(Long id) {

        Vehicle vehiculoEncontrado=  vehicleRepository.findAll().stream().filter(v->v.getId().equals(id)).findFirst().orElseThrow(()->new NotFoundException("Vehículo no encontrado"));

        vehicleRepository.deleteVehicle(vehiculoEncontrado.getId().intValue());
        return "Vehículo eliminado exitosamente.";
    }

    @Override
    public List<VehicleDto> fuelType(String type) {

        if(!vehicleRepository.existByFuelType(type)){
            throw new BadRequestException("No se encontraron vehículos con ese tipo de combustible.");
        }

        return searchAllVehicles()
                .stream()
                .filter(v-> v.getFuel_type().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> typeTransmission(String type) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> colect= vehicleRepository.findAll().stream()
                .filter(v->v.getTransmission()
                        .equalsIgnoreCase(type))
                .toList();

        if(colect.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos con ese tipo de tranmisión");
        }
        return colect.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public String updateFuel(Long id, String fuel) {

        List<String> listaFuel= vehicleRepository.findAll().stream().map(Vehicle::getTransmission).toList();

        if (fuel==null || fuel.isEmpty()|| !listaFuel.contains(fuel)) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión.");
        }

        Vehicle VehicleMatch = vehicleRepository
                .findAll().stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("No se encontraron vehículos con ese tipo de transmisión."));

        VehicleMatch.setFuel_type(fuel);


        return "Tipo de combustible del vehículo actualizado exitosamente";
    }

    /**
     * 11: Actualizar el tipo de combustible de un vehículo
     */
    @Override
    public Double getAverageCapacity(String brand) {

        boolean brandE= vehicleRepository.findAll().stream().anyMatch(v->v.getBrand().equals(brand));
        if(!brandE){
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }
        return vehicleRepository.findAll()
                .stream()
                .filter(v->v.getBrand().equalsIgnoreCase(brand))
                .mapToDouble(i->i.getPassengers())
                .average()
                .orElse(0.0);
    }




    @Override
    public List<VehicleDto> dimensionsCalc(String length, String width) {

        ObjectMapper maper= new ObjectMapper();
        String[] largo = length.split("-");
        String[] ancho = width.split("-");

        double minLargo =parseDouble(largo[0]);
        double maxLargo =parseDouble(largo[1]);
        double minAncho =parseDouble(ancho[0]);
        double maxAncho =parseDouble(ancho[1]);

        List<Vehicle> lista= vehicleRepository.findAll().stream()
                .filter(v->(v.getHeight()>= minLargo && v.getHeight()<=maxLargo) && (v.getWidth()>= minAncho && v.getWidth()<= maxAncho))
                .toList();
        if(lista.isEmpty()){
           throw new NotFoundException("No se encontraron vehículos con esas dimensiones.");
        }

        List<VehicleDto> dto = lista.stream()
                .map(v->maper.convertValue(v,VehicleDto.class))
                .toList();

        return dto;
    }

    @Override
    public List<VehicleDto> getByWeight(int min, int max) {
        List<Vehicle> vehiculos= vehicleRepository.findAll().stream().filter(v->v.getWeight()>=min && v.getWeight()<=max).toList();

        if(vehiculos.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos en ese rango de peso.");
        }
        ObjectMapper mapper= new ObjectMapper();
        return vehiculos.stream().map(v->mapper.convertValue(v,VehicleDto.class)).toList();
    }


}


