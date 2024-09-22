import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private int cantidad;

    public GuardaRopa() {
        prendas = new HashMap<>();
        cantidad = 0;
    }

    //Crear el método public Integer guardarPrendas(List<Prenda> listaDePrenda), en la Clase GuardaRopa, que recibe una
    // lista de prendas y devuelve el número identificador en donde quedaron asignadas las prendas, es decir la clave del
    // diccionario en donde guardamos las mismas.
    public Integer guardarPrendas(List<Prenda> listaPrendas) {

        if (!listaPrendas.isEmpty()) {
            cantidad++;
            prendas.put(cantidad, listaPrendas);
        }

        return cantidad;
    }

    //Crear el método public void mostrarPrendas() en la Clase GuardaRopa que imprime por pantalla todas las prendas que
    // quedan en el guardarropas junto con el número que les corresponde.
    public String mostrarPrendas() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, List<Prenda>> entrada : prendas.entrySet()) {
            //System.out.println("Numero guardaropas: " + entrada.getKey()+ " Lista de prendas: " + entrada.getValue());
            sb.append("Numero guardaropas: " + entrada.getKey() + " Lista de prendas: " + entrada.getValue());
        }
        return sb.toString();
    }

    //Crear el método public List<Prenda> devolverPrendas(Integer numero), en la Clase GuardaRopa que devuelve la lista
    // de prendas que están guardadas bajo ese número.
    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> devuelto = prendas.remove(numero);
        if (devuelto == null) {
            return devuelto;
        }

        System.out.println("No existe ese numero");
        return new ArrayList<>();

    }
}
