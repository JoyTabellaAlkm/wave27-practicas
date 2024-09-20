package ar.com.platos.contadorCalorias.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlatoFactory {
    public static Plato crearPlato(String nombrePlato, List<Ingrediente> ingredientesDisponibles) {
        Random random = new Random();
        List<Ingrediente> ingredientesSeleccionados = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Ingrediente ingrediente = ingredientesDisponibles.get(random.nextInt(5));
            ingredientesSeleccionados.add(ingrediente);
        }

        Integer peso = 0;
        for (Ingrediente ingrediente : ingredientesSeleccionados) {
            peso += random.nextInt(50, 150); // Peso entre 50g y 150g por ingrediente
        }

        return new Plato(nombrePlato, peso, ingredientesSeleccionados);
    }
}

