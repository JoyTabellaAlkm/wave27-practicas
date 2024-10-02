package com.meli.ejconcesionariaautos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private long numberOfKilometers;
    private int doors;
    private int price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;

    public Vehicle(String brand, String model, LocalDate manufacturingDate, long numberOfKilometers, int doors, int price, String currency, List<Service> services, int countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }
}
