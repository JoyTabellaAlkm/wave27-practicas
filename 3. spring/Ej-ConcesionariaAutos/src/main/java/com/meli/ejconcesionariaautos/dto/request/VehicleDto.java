package com.meli.ejconcesionariaautos.dto.request;

import com.meli.ejconcesionariaautos.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class VehicleDto {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private long numberOfKilometers;
    private int doors;
    private int price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;
}
