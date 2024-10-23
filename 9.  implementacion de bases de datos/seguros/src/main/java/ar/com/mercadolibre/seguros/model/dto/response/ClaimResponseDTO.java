package ar.com.mercadolibre.seguros.model.dto.response;

import ar.com.mercadolibre.seguros.model.Vehicle;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClaimResponseDTO {

    private Integer id;

    private LocalDate date;

    @JsonProperty("financial_loss")
    private Double financialLoss;

    @JsonProperty("vehicle_id")
    private Vehicle vehicle;
}
