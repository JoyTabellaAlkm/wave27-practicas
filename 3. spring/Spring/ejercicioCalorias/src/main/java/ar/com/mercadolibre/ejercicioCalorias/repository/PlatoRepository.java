package ar.com.mercadolibre.ejercicioCalorias.repository;

import ar.com.mercadolibre.ejercicioCalorias.entity.Ingrediente;
import ar.com.mercadolibre.ejercicioCalorias.entity.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

@Repository
public class PlatoRepository implements IRepository{
    private List<Ingrediente> ingredientes;
    private List<Plato> platos;
    private static int contadorId = 0;
    private final Random random;

    public PlatoRepository() {
        ObjectMapper objectMapper = new ObjectMapper();
        random = new Random();

        // Cargar Ingredientes
        try {
            ingredientes = objectMapper.readValue(new ClassPathResource("ingredientes.json").getInputStream(), new TypeReference<List<Ingrediente>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar ingredientes.json", e);
        }

        ObjectMapper objectMapper1 = new ObjectMapper();

        // Intentar Cargar Platos
        try{
            platos = objectMapper1.readValue(new ClassPathResource("platos.json").getInputStream(), new TypeReference<List<Plato>>() {});        }
        catch (IOException e) {
            System.out.println("platos.json no encontrado. Creando un nuevo archivo.");
            platos = crearPlatosPorDefecto();
            escribirPlatosEnArchivo(platos, "platos.json");
        }
    }

    private List<Plato> crearPlatosPorDefecto() {
        List<Plato> platos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Plato plato = crearPlatoAleatorio("Plato " + (i + 1));
            platos.add(plato);
        }
        return platos;
    }

    private void escribirPlatosEnArchivo(List<Plato> platos, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            URL resourceUrl = getClass().getClassLoader().getResource(fileName);
            if (resourceUrl != null) {
                File file = new File(resourceUrl.toURI());
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, platos);
                System.out.println("JSON con 10 platos creado en " + file.getPath());
            } else {
                System.out.println("No se puede crear el archivo " + fileName + " en resources.");
            }
        } catch (IOException | URISyntaxException e) {
            System.out.println("Error al escribir en el archivo " + fileName);
            e.printStackTrace();
        }
    }

    @Override
    public double sumarCalorias(List<Ingrediente> ingredientes) {
        return ingredientes.stream().mapToDouble(ingrediente -> ingrediente.getCalories()).sum();
    }

    public Plato crearPlatoAleatorio(String nombrePlato) {
        int numIngredientes = random.nextInt(Math.min(10, ingredientes.size())) + 1;
        List<Ingrediente> ingredientesSeleccionados = seleccionarIngredientesAleatorios(numIngredientes);
        double pesoTotal = sumarCalorias(ingredientesSeleccionados);
        contadorId ++;
        Plato plato = new Plato(contadorId, nombrePlato, pesoTotal, ingredientesSeleccionados);
        System.out.println(plato);
        return new Plato(contadorId, nombrePlato, pesoTotal, ingredientesSeleccionados);
    }

    private List<Ingrediente> seleccionarIngredientesAleatorios(int numIngredientes) {
        List<Ingrediente> shuffled = new ArrayList<>(ingredientes);
        Collections.shuffle(shuffled);

        return shuffled.subList(0, Math.min(numIngredientes, ingredientes.size()));
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

    public Optional<Plato> getFindByName(String namePlato){
        Optional<Plato> plato1 = platos.stream().filter(plato -> plato.getNamePlato().equalsIgnoreCase(namePlato)).findFirst();
        System.out.println(plato1);
        return plato1;
    }


}
