package ar.com.platos.contadorCalorias.service.impl;

import ar.com.platos.contadorCalorias.dto.PlatoDTO;
import ar.com.platos.contadorCalorias.entity.Ingrediente;
import ar.com.platos.contadorCalorias.entity.Plato;
import ar.com.platos.contadorCalorias.entity.PlatoFactory;
import ar.com.platos.contadorCalorias.repository.CalculadoraDeCalRepository;
import ar.com.platos.contadorCalorias.service.ICalculadoraDeCalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CalculadoraDeCalService implements ICalculadoraDeCalService {

    @Autowired
    private CalculadoraDeCalRepository calculadoraDeCalRepository;

    private List<Plato> crearPlatos(List<String> platos) {
        List<Plato> platoList = new ArrayList<>();
        for (int i = 0; i < platos.size(); i++) {
            platoList.add(crearPlato(platos.get(i)));
        }
        return platoList;
    }

    private Plato crearPlato(String nombre) {
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

    @Override
    public List<PlatoDTO> mostrarInfoDeCadaPlato(List<String> platos) {
        List<Plato> platosList = crearPlatos(platos);
        List<PlatoDTO> platoDTOS = new ArrayList<>();
        for (int i = 0; i < platosList.size(); i++) {
            platoDTOS.add(new PlatoDTO(platosList.get(i).getIngredientes(), platosList.get(i).getNombre(), calcularCaloriasDePlato(platosList.get(i)),ingredienteMasCaloricoDelPlato(platosList.get(i))));
        }
        return platoDTOS;
    }
}