package org.mercadolibre.calculadoracalorias.dto;

import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.calculadoracalorias.entity.Ingredients;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishDTO implements Serializable {
    private String name;
    private double weight;
    private List<Ingredients> ingredients;
}
