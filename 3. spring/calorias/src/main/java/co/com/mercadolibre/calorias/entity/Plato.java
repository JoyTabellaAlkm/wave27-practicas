package co.com.mercadolibre.calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Plato {
    String name;
    List<Ingrediente> ingredientes;
    double cantidadCalorias;
    Integer pesoPlato;

    public Plato(String name, List<Ingrediente> ingredientes, Integer pesoPlato) {
        this.name = name;
        this.ingredientes = ingredientes;
        this.pesoPlato = pesoPlato;
        cantidadCalorias = calcularCalorias()*pesoPlato;
    }

    public double calcularCalorias(){
        return ingredientes.stream().mapToDouble(Ingrediente::getCalories)
                .sum();
    }
}
