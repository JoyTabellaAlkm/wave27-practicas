package com.mycar.cardealership.repository;

import com.mycar.cardealership.entity.Car;

import java.util.List;

public interface ICarRepository {
    List<Car> findAll();
}
