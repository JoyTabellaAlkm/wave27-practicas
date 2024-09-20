package org.example.concesionaria.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Vehicle {
    public UUID id;
    private String brand;
    private String model;
    private Date manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<Service> services;

    public Vehicle(String brand, String model, Date manufacturingDate, Integer numberOfKilometers, Integer doors, Integer price, String currency, List<Service> services, Integer countOfOwners) {
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

    private Integer countOfOwners;
}
