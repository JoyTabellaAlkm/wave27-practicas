package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> prendas;
    private Integer idActual;

    public GuardaRopa() {
        this.idActual = 0;
        this.prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        this.idActual++;
        this.prendas.put(idActual, listaDePrendas);
        return this.idActual;
    }

    public String mostrarPrendas(){
        this.prendas.forEach((k, v) -> System.out.println("ID: " + k + " Prendas: " + v.stream().map(prenda -> prenda.getMarca() + " " + prenda.getModelo()).toList()));
        return "Se mostraron las prendas";
    }

    public List<Prenda> devolverPrendas(Integer numero){
        if(this.prendas.get(numero) == null){
            return new ArrayList<>();
        }
        return this.prendas.get(numero);
    }

    public void quitarPrendas(Integer numero){
        this.prendas.remove(numero);
    }
}
