import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer contador;
    private Map<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        this.contador = 0;
        this.prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        prendas.put(contador, listaDePrenda);
        return contador++;
    }

    public String mostrarPrendas() {
        List<String> strings = prendas.entrySet().stream().
                map(entry -> "%d: %s".formatted(entry.getKey(), entry.getValue().toString()))
                .toList();
        return String.join("\n", strings);
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendas.remove(numero);
    }
}
