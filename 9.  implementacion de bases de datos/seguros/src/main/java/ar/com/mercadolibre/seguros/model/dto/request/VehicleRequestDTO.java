package ar.com.mercadolibre.seguros.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VehicleRequestDTO {

    @JsonProperty("license_plate")
    private String licensePlate;

    private String brand;
    private String model;
    private Integer year;
    private Integer wheels;
}
