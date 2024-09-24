package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import org.modelmapper.ModelMapper;

import java.util.List;

public class MapperUtils {

    public Vehicle mapperToEntity(VehicleDto vehicleDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vehicleDto, Vehicle.class);
    }

    public VehicleDto mapperToDto(Vehicle vehicle) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vehicle, VehicleDto.class);
    }

    public List<VehicleDto> mapperToDtoList(List<Vehicle> listVehicle) {
        ModelMapper modelMapper = new ModelMapper();

        return listVehicle.stream().map(v -> modelMapper.map(v, VehicleDto.class)).toList();
    }

    public List<Vehicle> mapperToEntityList(List<VehicleDto> listVehicleDto) {
        ModelMapper modelMapper = new ModelMapper();

        return listVehicleDto.stream().map(v -> modelMapper.map(v, Vehicle.class)).toList();
    }
}
