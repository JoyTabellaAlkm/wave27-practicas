package com.mycar.cardealership.service;

import com.mycar.cardealership.dto.CarCreationDto;
import com.mycar.cardealership.dto.CarDto;
import com.mycar.cardealership.entity.Car;
import com.mycar.cardealership.entity.ServiceEntity;

import java.util.List;

public interface ICarService {
    List<CarDto> findAll();
    CarDto create(CarCreationDto carCreationDto);
    List<CarDto> findCarsByDate(String since, String to);
    List<CarDto> findCarsByPrice(String since, String to);
    Car findById(Long id);
}
