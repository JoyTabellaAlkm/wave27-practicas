package com.mycar.cardealership.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycar.cardealership.entity.Car;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarRepositoryImpl implements ICarRepository {
    private List<Car> carList = new ArrayList<>();

    public CarRepositoryImpl() throws IOException {
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Car> cars;

        file = ResourceUtils.getFile("classpath:carBD.json");
        cars = objectMapper.readValue(file,new TypeReference<List<Car>>(){});

        carList = cars;
    }

    public List<Car> findAll() {
        return this.carList;
    }

    public Optional<Car> findById(long id) {
        return carList.stream()
                .filter(car -> car.getId() == id)
                .findFirst();
    }

    public void save(Car car) {
        this.carList.add(car);
    }

    public boolean idExist(long id) {
        return carList.stream().anyMatch(car -> car.getId() == id);
    }
}
