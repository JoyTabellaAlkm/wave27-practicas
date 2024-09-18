package repository;

import model.Prenda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> ropero;
    private Integer contador;


    public GuardaRopa() {
        this.contador = 0;
        this.ropero = new HashMap<>();
    }



    public Map<Integer, List<Prenda>> getRopero() {
        return ropero;
    }

    public void setRopero(Map<Integer, List<Prenda>> ropero) {
        this.ropero = ropero;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }


    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        ropero.put(contador, listaDePrenda);
        return contador++;
    }

    public String mostrarPrendas() {
        List<String> strings = ropero.entrySet().stream().
                map(entry -> "%d: %s".formatted(entry.getKey(), entry.getValue().toString()))
                .toList();
        return String.join("\n", strings);
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return ropero.remove(numero);
    }
    }


