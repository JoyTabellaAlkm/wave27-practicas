package com.meli.showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaResponseDto {
    private Long numero;
    private LocalDate fecha;
    private Double total;
    @JsonProperty("medio_de_pago")
    private String medioDePago;
    @JsonProperty("lista_de_prendas")
    private List<PrendaResponseDto> listaDePrendas;
}
