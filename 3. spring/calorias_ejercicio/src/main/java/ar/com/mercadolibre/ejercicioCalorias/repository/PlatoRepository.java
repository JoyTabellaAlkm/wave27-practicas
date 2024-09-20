package ar.com.mercadolibre.ejercicioCalorias.repository;

import ar.com.mercadolibre.ejercicioCalorias.entity.Ingrediente;
import ar.com.mercadolibre.ejercicioCalorias.entity.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Repository
public class PlatoRepository implements IPlatoRepository {
    private List<Plato> platos;
    private static int contadorId = 0;
    private final Random random;

    public PlatoRepository() {
        ObjectMapper objectMapper = new ObjectMapper();
        random = new Random();

        ObjectMapper objectMapper1 = new ObjectMapper();

        // Intentar Cargar Platos
        try{
            File file = ResourceUtils.getFile("classpath:platos.json");
            platos = objectMapper1.readValue(file, new TypeReference<>() {});
        }
        catch (IOException e) {
            System.out.println("platos.json no encontrado. Creando un nuevo archivo.");
        }
    }

    @Override
    public double sumarCalorias(List<Ingrediente> ingredientes) {
        return ingredientes.stream().mapToDouble(ingrediente -> ingrediente.getCalories()).sum();
    }

    public Ingrediente getIngredienteMayor(){
        return platos.stream()
                .flatMap(plato -> plato.getIngredienteList().stream())
                .max(Comparator.comparingDouble(Ingrediente::getCalories))
                .orElse(null);
    }

    public List<Plato> getAllPlatos(){
        return platos.stream().toList();
    }

    public Optional<Plato> getFindByName(String platoABuscar){
        Optional<Plato> plato1 = this.platos.stream().filter(plato -> plato.getNamePlato().equalsIgnoreCase(platoABuscar)).findFirst();
        System.out.println(plato1);
        return plato1;
    }

    public List<Plato> getFindByName(List<String> platoABuscar){
        List<Plato> returnVal = new ArrayList<>();
        for(String stringAConsultar : platoABuscar){
            Plato p = this.platos.stream().filter(plato -> plato.getNamePlato().equalsIgnoreCase(stringAConsultar)).findFirst().get();
            returnVal.add(p);
        }
        return returnVal;
    }
}
