package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendas = new ArrayList<>();
        Prenda camisa = new Prenda("Koaj", "Polo");
        Prenda pantalon = new Prenda("Diesel","Jean");

        prendas.add(camisa);
        prendas.add(pantalon);

        GuardaRopa guardaRopa = new GuardaRopa();

        Integer idPrenda = guardaRopa.guardarPrendas(prendas);
        System.out.println(idPrenda);
        System.out.println(guardaRopa.mostrarPrendas());
        System.out.println(guardaRopa.devolverPrendas(idPrenda));
    }
}