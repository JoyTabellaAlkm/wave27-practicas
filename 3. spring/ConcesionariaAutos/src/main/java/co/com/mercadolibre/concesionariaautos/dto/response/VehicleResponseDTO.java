package co.com.mercadolibre.concesionariaautos.dto.response;

import co.com.mercadolibre.concesionariaautos.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data @AllArgsConstructor @NoArgsConstructor
public class VehicleResponseDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;
}
