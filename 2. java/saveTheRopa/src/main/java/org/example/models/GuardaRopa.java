package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuardaRopa {
    private Map<Integer, List<Prenda>> listaPrendas = new HashMap<>();
    private int id = 0;

    public Integer guardarPrendas(List<Prenda> prendas) {
        Integer idActual = this.id;
        this.listaPrendas.put(id, prendas);
        id++;

        return idActual;
    }

    public void mostrarPrendas() {
        listaPrendas.forEach((key, value) -> System.out.println("Key: " + key + " prendas " + value));
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return listaPrendas.get(numero);
    }
}
