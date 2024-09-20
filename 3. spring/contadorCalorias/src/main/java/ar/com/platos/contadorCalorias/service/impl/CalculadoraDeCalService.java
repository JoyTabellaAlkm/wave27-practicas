package ar.com.platos.contadorCalorias.service.impl;

import ar.com.platos.contadorCalorias.dto.PlatoDTO;
import ar.com.platos.contadorCalorias.entity.Ingrediente;
import ar.com.platos.contadorCalorias.entity.Plato;
import ar.com.platos.contadorCalorias.entity.PlatoFactory;
import ar.com.platos.contadorCalorias.repository.CalculadoraDeCalRepository;
import ar.com.platos.contadorCalorias.service.ICalculadoraDeCalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CalculadoraDeCalService implements ICalculadoraDeCalService {

    @Autowired
    private CalculadoraDeCalRepository calculadoraDeCalRepository;

    public Plato crearPlato(String nombre) {
        List<Ingrediente> ingredientes = calculadoraDeCalRepository.leerArchivo();

        Plato plato = null;

        if (ingredientes != null && !ingredientes.isEmpty()) {
            plato = PlatoFactory.crearPlato(nombre, ingredientes);
        } else {
            System.out.println("No se encontraron ingredientes.");
        }
        return plato;
    }

    @Override
    public Integer calcularCaloriasDePlato(Plato plato) {
        return plato.getIngredientes().stream().mapToInt(Ingrediente::getCalorias).sum();
    }

    @Override
    public Ingrediente ingredienteMasCaloricoDelPlato(Plato plato) {
        return plato.getIngredientes().stream().max(Comparator.comparing(Ingrediente::getCalorias)).get();
    }

    @Override
    public PlatoDTO mostrarInfoDePlato(String nombreDePlato) {
        Plato plato = crearPlato(nombreDePlato);
        return new PlatoDTO(plato.getIngredientes(),plato.getNombre(),calcularCaloriasDePlato(plato),ingredienteMasCaloricoDelPlato(plato));
    }
}