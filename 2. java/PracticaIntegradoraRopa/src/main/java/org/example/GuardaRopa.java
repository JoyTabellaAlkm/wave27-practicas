package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer id = 0;
    private Map<Integer, List<Prenda>> listaPrenda = new HashMap<>();

    public Integer guardarPrendas(List<Prenda> listaPrendas){
        this.listaPrenda.put(this.id, listaPrendas);
        Integer idGuardado = this.id;
        this.id++;
        return idGuardado;
    }

    public void mostrarPrendas(){
        this.listaPrenda.values().forEach(System.out::println);
    }

    public List<Prenda> devolverPrendas(Integer id){
        return this.listaPrenda.get(id);
    }
}
