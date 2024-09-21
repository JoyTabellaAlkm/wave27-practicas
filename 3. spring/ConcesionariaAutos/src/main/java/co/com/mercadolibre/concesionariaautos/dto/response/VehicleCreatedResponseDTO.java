package co.com.mercadolibre.concesionariaautos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class VehicleCreatedResponseDTO {
    private Long id;
    private String brand;
    private String model;
}
