package com.mercadolibre.showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaResponseDTO {

    private LocalDate fecha;

    private Double total;

    @JsonProperty("medio_pago")
    private String medioPago;

    @JsonProperty("lista_prendas")
    private List<PrendaResponseDTO> listaPrendas;
}
