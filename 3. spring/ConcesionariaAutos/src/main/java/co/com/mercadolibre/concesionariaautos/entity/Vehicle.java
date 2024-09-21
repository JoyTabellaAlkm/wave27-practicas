package co.com.mercadolibre.concesionariaautos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;
@Data @AllArgsConstructor @NoArgsConstructor
public class Vehicle {
    @NonNull
private Long id;
    @NonNull
private String brand;
    @NonNull
private String model;
private LocalDate manufacturingDate;
private Integer numberOfKilometers;
private Integer doors;
private Double price;
private String currency;
private List<Service> services;
private Integer countOfOwners;
}
