package co.com.mercadolibre.calcularcalorias.repository.impl;

import co.com.mercadolibre.calcularcalorias.entity.Ingrediente;
import co.com.mercadolibre.calcularcalorias.entity.Plato;
import co.com.mercadolibre.calcularcalorias.repository.IPlatoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository {
    @Autowired
    IngredienteRepositoryImpl ingredienteRepository;

    private List<Plato> listaPlatos = new ArrayList<>();
    private Long idplato = 1L;

    @PostConstruct
    public void init() {
        this.listaPlatos = crearPlatos(ingredienteRepository.getListaIngredientes());
    }

    private List<Plato> crearPlatos(List<Ingrediente> listaIngredientes){
        List<Plato> listaPlatos = new ArrayList<>();
        List<Ingrediente> ingredientesSeleccionados1 = new ArrayList<>();
        List<Ingrediente> ingredientesSeleccionados2 = new ArrayList<>();
        ingredientesSeleccionados1.add(listaIngredientes.get(0));
        ingredientesSeleccionados1.add(listaIngredientes.get(10));
        ingredientesSeleccionados2.add(listaIngredientes.get(23));
        ingredientesSeleccionados2.add(listaIngredientes.get(7));

        listaPlatos.add(new Plato(idplato++, "Hamburguesa", 400, ingredientesSeleccionados1)); // Asegúrate de pasar la lista de ingredientes
        listaPlatos.add(new Plato(idplato++, "Pizza", 800, ingredientesSeleccionados2)); // Asegúrate de pasar la lista de ingredientes

        return listaPlatos; // No olvides devolver la lista de platos
    }

    @Override
    public List<Plato> verPlatos() {
        return listaPlatos;
    }
}
