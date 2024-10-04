package co.com.mercadolibre.calorias.services.impl;

import co.com.mercadolibre.calorias.entity.Ingrediente;
import co.com.mercadolibre.calorias.entity.Plato;
import co.com.mercadolibre.calorias.repository.ICaloriasRespository;
import co.com.mercadolibre.calorias.services.ICaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaloriaServices implements ICaloriasService {

    @Autowired
    ICaloriasRespository iCaloriasRespository;

    public Plato encontrarPlato(String name){
        return  iCaloriasRespository.obtenerPlatos().stream()
                .filter(p -> p.getName().equals(name))
                .map(p-> new Plato(p.getName(),p.getIngredientes(),p.getPesoPlato())).findFirst().get();
    }

    @Override
    public List<Ingrediente> listaIngredientes(String name) {
        return encontrarPlato(name).getIngredientes();
    }

    public double calcularCalorias(String name) {
        return encontrarPlato(name).getCantidadCalorias();
    }


}
