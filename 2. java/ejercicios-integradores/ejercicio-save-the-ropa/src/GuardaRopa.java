import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer contador;
    private Map<Integer, List<Prenda>> guardaRopa;

    public GuardaRopa() {
        this.contador = 0;
        this.guardaRopa = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> prendasAGuardar){

        Integer key = contador;
        guardaRopa.put(key,prendasAGuardar);
        contador++;
        return key;
    }

    public List<Prenda> devolverPrendas(Integer numero){

        List<Prenda> prendas = guardaRopa.remove(numero);
        return prendas;
    }

    public void mostrarPrendas(){
        for (Integer key: guardaRopa.keySet()){
            List<Prenda> prendaList = guardaRopa.get(key);
            System.out.println(prendaList);
        }
    }

    public Map<Integer, List<Prenda>> getGuardaRopa() {
        return guardaRopa;
    }
}
