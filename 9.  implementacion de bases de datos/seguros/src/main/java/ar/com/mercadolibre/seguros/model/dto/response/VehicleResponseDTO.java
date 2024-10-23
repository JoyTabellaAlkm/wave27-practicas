package ar.com.mercadolibre.seguros.model.dto.response;

import ar.com.mercadolibre.seguros.model.Claim;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class VehicleResponseDTO {
    private Integer id;

    @JsonProperty("license_plate")
    private String licensePlate;

    private String brand;
    private String model;
    private Integer year;
    private Integer wheels;
}
