package co.com.mercadolibre.concesionariaautos.dto.request;

import co.com.mercadolibre.concesionariaautos.entity.Service;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;
@Getter
public class VehicleCreateRequestDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private List<Service> services;
    private Integer countOfOwners;
}
