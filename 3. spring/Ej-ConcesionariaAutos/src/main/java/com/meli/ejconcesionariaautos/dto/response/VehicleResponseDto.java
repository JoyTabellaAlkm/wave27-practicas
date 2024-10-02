package com.meli.ejconcesionariaautos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class VehicleResponseDto {
    private int id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private long numberOfKilometers;
    private int doors;
    private int price;
    private String currency;
    private int countOfOwners;
}
