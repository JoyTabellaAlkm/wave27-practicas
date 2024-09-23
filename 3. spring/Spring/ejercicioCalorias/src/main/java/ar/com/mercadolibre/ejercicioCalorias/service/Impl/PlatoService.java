package ar.com.mercadolibre.ejercicioCalorias.service.Impl;

import ar.com.mercadolibre.ejercicioCalorias.entity.Ingrediente;
import ar.com.mercadolibre.ejercicioCalorias.entity.Plato;
import ar.com.mercadolibre.ejercicioCalorias.repository.PlatoRepository;
import ar.com.mercadolibre.ejercicioCalorias.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PlatoService implements IService {

    private final PlatoRepository platoRepository;

    @Autowired
    public PlatoService(PlatoRepository platoRepository){
        this.platoRepository = platoRepository;
    }

    @Override
    public double getCaloriasPlato(String namePlato){
        Optional<Plato> plato = platoRepository.getFindByName(namePlato);
        return plato.get().getPeso();
    }

    @Override
    public List<Ingrediente> getListaIngredientesPlato(String namePlato){
        Optional<Plato> plato = platoRepository.getFindByName(namePlato);
        return plato.get().getIngredienteList();
    }

    @Override
    public Ingrediente getIngredienteMasCaloria(String namePlato){
        Optional<Plato> plato = platoRepository.getFindByName(namePlato);
        return  plato.stream()
                .flatMap(plato1 -> plato1.getIngredienteList().stream())
                .max(Comparator.comparingDouble(Ingrediente::getCalories))
                .orElse(null);
    }

    @Override
    public List<Plato> getAllPlatos(){
        return platoRepository.getAllPlatos();
    }

}
