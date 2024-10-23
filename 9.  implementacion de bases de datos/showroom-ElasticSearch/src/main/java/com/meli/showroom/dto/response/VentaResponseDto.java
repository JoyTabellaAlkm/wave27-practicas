package com.meli.showroom.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaResponseDto {
    private String numero;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String fecha;
    private Double total;
    @JsonProperty("medio_de_pago")
    private String medioDePago;
    @JsonProperty("lista_de_prendas")
    private List<PrendaResponseDto> listaDePrendas;
}
