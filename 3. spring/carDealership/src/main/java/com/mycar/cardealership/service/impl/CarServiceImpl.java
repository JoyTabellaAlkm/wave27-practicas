package com.mycar.cardealership.service.impl;

import com.mycar.cardealership.dto.CarCreationDto;
import com.mycar.cardealership.dto.CarDto;
import com.mycar.cardealership.dto.ServiceDto;
import com.mycar.cardealership.entity.Car;
import com.mycar.cardealership.exception.NotFoundException;
import com.mycar.cardealership.repository.CarRepositoryImpl;
import com.mycar.cardealership.service.ICarService;
import com.mycar.cardealership.entity.ServiceEntity;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements ICarService {
    private static Long CAR_ID = 10L;
    private static Long SERVICE_ID = 20L;
    private final int DAY = 2;
    private final int MONTH = 1;
    private final int YEAR = 0;
    private CarRepositoryImpl carRepository;

    public CarServiceImpl(CarRepositoryImpl carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDto> findAll() {
        List<Car> cars = carRepository.findAll();

        if (cars.isEmpty()) {
            throw new NotFoundException("La lista de autos está vacía");
        }

        return cars.stream()
                .map(this::mapCarToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarDto create(CarCreationDto carCreationDto) {
        CAR_ID++;

        Car car = mapDtoToCar(CAR_ID, carCreationDto);
        carRepository.save(car);

        return mapCarToDto(car);
    }

    @Override
    public List<CarDto> findCarsByDate(String since, String to) {
        LocalDate sinceDate = formatDate(since);
        LocalDate toDate = formatDate(to);

        List<Car> cars = carRepository.findAll();
        if (cars.isEmpty()) {
            throw new NotFoundException("No hay autos registrados en el sitio");
        }

        List<Car> carsFiltered = new ArrayList<>();
        for (Car car : cars) {
            LocalDate manufactured = formatDate(car.getManufacturingDate());

            boolean isBetweenDates = (manufactured.isAfter(sinceDate) || manufactured.isEqual(sinceDate)) &&
                    (manufactured.isBefore(toDate)  || manufactured.isEqual(toDate));

            if (isBetweenDates) {
                carsFiltered.add(car);
            }
        }

        if (carsFiltered.isEmpty()) {
            throw new NotFoundException("No hay autos fabricados entre estas fechas");
        }

        return carsFiltered.stream().map(this::mapCarToDto).toList();
    }

    @Override
    public List<CarDto> findCarsByPrice(String since, String to) {
        List<Car> filteredCars = carRepository.findAll()
                .stream()
                .filter(car -> Integer.parseInt(car.getPrice()) >= Integer.parseInt(since) &&
                        Integer.parseInt(car.getPrice()) < Integer.parseInt(to))
                .toList();

        if (filteredCars.isEmpty()) {
            throw new NotFoundException("No hay autos con estos parametros");
        }

        return filteredCars.stream().map(this::mapCarToDto).toList();
    }

    @Override
    public Car findById(Long id) {
        if (!carRepository.idExist(id)) {
            throw new NotFoundException("No existe un vehiculo con ese id");
        }

        return carRepository.findById(id).orElse(null);
    }

    private CarDto mapCarToDto(Car car) {
        return new CarDto(
                car.getBrand(),
                car.getModel(),
                car.getManufacturingDate(),
                car.getNumberOfKilometers(),
                car.getDoors(),
                car.getPrice(),
                car.getCurrency(),
                car.getCountOfOwners()
                );
    }

    private Car mapDtoToCar(Long id, CarCreationDto carCreationDto) {
        List<ServiceEntity> services = carCreationDto.getServices().stream()
                .map(this::mapToServiceEntity)
                .toList();

        return new Car(
                id,
                carCreationDto.getBrand(),
                carCreationDto.getModel(),
                carCreationDto.getManufacturingDate(),
                carCreationDto.getNumberOfKilometers(),
                carCreationDto.getDoors(),
                carCreationDto.getPrice(),
                carCreationDto.getCurrency(),
                services,
                carCreationDto.getCountOfOwners()
                );
    }

    private ServiceEntity mapToServiceEntity(ServiceDto serviceDto) {
        return new ServiceEntity(
                SERVICE_ID,
                serviceDto.getDate(),
                serviceDto.getKilometers().toString(),
                serviceDto.getDescription()
        );
    }

    private LocalDate formatDate(String dateStr) {
        String[] dateArr = dateStr.split("-");

        return LocalDate.of(
                Integer.parseInt(dateArr[YEAR]),
                Integer.parseInt(dateArr[MONTH]),
                Integer.parseInt(dateArr[DAY])
        );
    }
}
