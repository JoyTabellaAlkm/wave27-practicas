package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
public class Mapper {

    public List<VehicleDto> mapperListDto(List<Vehicle> vehicleList) {
        ModelMapper modelMapper = new ModelMapper();

        return vehicleList.stream().map(vehicle -> modelMapper.map(vehicle, VehicleDto.class)).toList();
    }
}
