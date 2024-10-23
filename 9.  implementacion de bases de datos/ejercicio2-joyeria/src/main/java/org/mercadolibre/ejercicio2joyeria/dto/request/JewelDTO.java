package org.mercadolibre.ejercicio2joyeria.dto.request;

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
public class JewelDTO {
    private String name;
    @Enumerated(EnumType.STRING)
    private Material material;
    private Double weight;
    private String peculiarity;
    @Column(name = "has_stone")
    private Boolean hasStone;
    @Column(name = "sale_or_not")
    private Boolean saleOrNot;
}
