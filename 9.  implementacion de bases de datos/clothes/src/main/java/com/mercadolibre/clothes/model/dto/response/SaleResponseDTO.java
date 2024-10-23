package com.mercadolibre.clothes.model.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.clothes.model.Clothing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponseDTO {

    private Long code;
    private LocalDate date;
    private Double total;
    @JsonProperty("payment_method")
    private String paymentMethod;

    private List<Clothing> clothing;
}
