package com.meli.showroom.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaRequestDto {
    private String fecha;
    private Double total;
    @JsonProperty("medio_de_pago")
    private String medioDePago;
    @JsonProperty("lista_de_prendas")
    private List<String> listaDePrendas;
}
