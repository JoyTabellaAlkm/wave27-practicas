package org.mercadolibre.calculadora_calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.mercadolibre.calculadora_calorias.entity.Ingrediente;
import org.mercadolibre.calculadora_calorias.entity.Plato;
import org.mercadolibre.calculadora_calorias.service.IIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class PlatoRepository {

    private List<Plato> platos = new ArrayList<>();
    IIngredienteService ingredienteService;

    @Autowired
    public PlatoRepository(IIngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
        this.platos = loadAll();
    }

    public List<Plato> loadAll() {
        List<Plato> platosAux = new ArrayList<>();

        Ingrediente papa = ingredienteService.getByName("Papas cocidas");
        Ingrediente manteca = ingredienteService.getByName("Manteca");
        Ingrediente leche = ingredienteService.getByName("Leche descremada");

        platosAux.add(new Plato("Pure", List.of(papa, manteca, leche)));

        Ingrediente pollo = ingredienteService.getByName("Pollo, Muslo");

        platosAux.add(new Plato("Pollo cocido", List.of(pollo)));

        return platosAux;
    }


}
