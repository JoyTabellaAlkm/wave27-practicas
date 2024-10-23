package ar.com.mercadolibre.seguros.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClaimRequestDTO {

    private LocalDate date;

    @JsonProperty("financial_loss")
    private Double financialLoss;

    @JsonProperty("vehicle_id")
    private Integer vehicleId;

}
