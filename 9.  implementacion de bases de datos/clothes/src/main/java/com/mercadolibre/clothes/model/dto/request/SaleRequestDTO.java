package com.mercadolibre.clothes.model.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SaleRequestDTO {
    private LocalDate date;
    private Double total;
    private String paymentMethod;
    private List<Long> clothing;
}
