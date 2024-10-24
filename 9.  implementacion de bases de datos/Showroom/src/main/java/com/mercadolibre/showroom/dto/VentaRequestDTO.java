package com.mercadolibre.showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaRequestDTO {

    @NotNull(message = "El medio de pago no puede ser nulo")
    @JsonProperty("medio_pago")
    private String medioPago;
    @NotEmpty(message = "Debe de agregar al menos una prenda a la venta")
    @JsonProperty("lista_prendas")
    private List<Long> listaPrendas;
}
