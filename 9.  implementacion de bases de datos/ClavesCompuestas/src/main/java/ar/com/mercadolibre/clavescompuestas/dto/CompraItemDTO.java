package ar.com.mercadolibre.clavescompuestas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraItemDTO {
    private Long id;

    private LocalDate fecha;

    private String descripcion;

    private Double total;

    private Set<ItemDTO> items;
}
