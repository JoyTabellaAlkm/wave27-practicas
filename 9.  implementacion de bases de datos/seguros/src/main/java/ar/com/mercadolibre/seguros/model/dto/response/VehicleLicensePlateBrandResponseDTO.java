package ar.com.mercadolibre.seguros.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleLicensePlateBrandResponseDTO {
    private String licensePlate;
    private String brand;
}
