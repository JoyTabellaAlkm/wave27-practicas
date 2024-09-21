package co.com.mercadolibre.calcularcalorias.dto.response;

import co.com.mercadolibre.calcularcalorias.entity.Ingrediente;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
@Getter @Setter
public class PlatoDTOResponse {
    private List<Ingrediente> ingredientes;
    private Integer totalCalorias;
    private Ingrediente ingredienteCalorico;

    public PlatoDTOResponse(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
        this.totalCalorias = calcularTotalCalorias();
        this.ingredienteCalorico = calcularIngredienteCalorico();
    }

    private Integer calcularTotalCalorias(){
       Integer totalCalorias =  ingredientes.stream().mapToInt(ingrediente -> ingrediente.getCalories()).sum();
        return totalCalorias;
    }

    private Ingrediente calcularIngredienteCalorico(){
        Optional<Ingrediente> ingredienteCalorico = ingredientes.stream().max(Comparator.comparingInt(Ingrediente::getCalories));
        return ingredienteCalorico.get();
    }
}
