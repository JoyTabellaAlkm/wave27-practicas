package ar.com.mercadolibre.ejercicioCalorias.service.Impl;

import ar.com.mercadolibre.ejercicioCalorias.dto.getCaloriesDTO;
import ar.com.mercadolibre.ejercicioCalorias.entity.Ingrediente;
import ar.com.mercadolibre.ejercicioCalorias.entity.Plato;
import ar.com.mercadolibre.ejercicioCalorias.repository.IPlatoRepository;
import ar.com.mercadolibre.ejercicioCalorias.repository.PlatoRepository;
import ar.com.mercadolibre.ejercicioCalorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoService implements IPlatoService {

    private final IPlatoRepository platoRepository;

    @Autowired
    public PlatoService(PlatoRepository platoRepository){
        this.platoRepository = platoRepository;
    }

    @Override
    public double getCaloriasPlato(getCaloriesDTO dto){
        List<String> stringsAConsultar = dto.getPlatos();
        return platoRepository.getFindByName(stringsAConsultar).stream().mapToDouble(p -> p.getIngredienteList().stream().mapToInt(Ingrediente::getCalories).sum()).sum();
    }

    @Override
    public List<Ingrediente> getListaIngredientesPlato(String namePlato){
        Optional<Plato> plato = platoRepository.getFindByName(namePlato);
        System.out.println(plato);
        return plato.get().getIngredienteList();
    }

    @Override
    public Ingrediente getIngredienteMasCaloria(){
        return platoRepository.getIngredienteMayor();
    }

    @Override
    public List<Plato> getAllPlatos(){
        return platoRepository.getAllPlatos();
    }
}
