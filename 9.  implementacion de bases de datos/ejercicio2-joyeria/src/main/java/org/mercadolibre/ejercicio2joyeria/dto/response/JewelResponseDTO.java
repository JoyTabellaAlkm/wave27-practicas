package org.mercadolibre.ejercicio2joyeria.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.ejercicio2joyeria.entity.Material;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelResponseDTO {
    private Long id;
    private String name;
    private Material material;
    private Double weight;
    private String peculiarity;
    private Boolean hasStone;
    private Boolean saleOrNot;
}
