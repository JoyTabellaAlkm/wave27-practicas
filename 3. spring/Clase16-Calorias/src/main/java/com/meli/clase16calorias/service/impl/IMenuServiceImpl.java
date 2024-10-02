package com.meli.clase16calorias.service.impl;

import com.meli.clase16calorias.dto.PlatoDTO;
import com.meli.clase16calorias.dto.PlatoEstandarDTO;
import com.meli.clase16calorias.exception.NotFoundException;
import com.meli.clase16calorias.model.Ingrediente;
import com.meli.clase16calorias.model.Plato;
import com.meli.clase16calorias.repository.IngredienteRepository;
import com.meli.clase16calorias.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class IMenuServiceImpl implements IMenuService {

    @Autowired
    IngredienteRepository ingredienteRepository;

    @Override
    public List<PlatoEstandarDTO> showMenu() {
        List<PlatoEstandarDTO> menu =  ingredienteRepository.getMenu().stream()
                .map(plato->new PlatoEstandarDTO(plato.getNombre(), plato.getIngredientes()))
                .toList();
        if (menu.isEmpty()){
            throw new NotFoundException("El menú está vacío");
        }
        return menu;
    }

    @Override
    public PlatoDTO showPlateByWeight(String name, int weight) {
        Plato platoBusqueda = ingredienteRepository.getMenu().stream()
                .filter(plato -> plato.getNombre().equals(name))
                .findFirst().orElse(null);
        if (platoBusqueda==null){
            throw new NotFoundException("No existe un plato con el nombre %s".formatted(name));
        }
        double calorias = platoBusqueda.getIngredientes().stream()
                .mapToDouble(Ingrediente::getCalorias).sum();
        calorias = (calorias * weight)/(platoBusqueda.getIngredientes().size()*100);
        Ingrediente ingredienteMaxCalorias = platoBusqueda.getIngredientes().stream()
                .max(Comparator.comparing(Ingrediente::getCalorias)).orElse(null);
        return new PlatoDTO(platoBusqueda.getNombre(), weight, calorias, platoBusqueda.getIngredientes(), ingredienteMaxCalorias);
    }
}
