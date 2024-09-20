package org.example.concesionaria.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.concesionaria.entities.Service;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class createVehicleDTO {
    private String brand;
    private String model;
    private Date manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<Service> services;
    private Integer countOfOwners;
}