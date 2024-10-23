package ar.com.mercadolibre.seguros.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehiclePlateBrandModelResponseDTO {
    private String licensePlate;
    private String brand;
    private String model;
}
