package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();
        //Escenario 1

        Integer id = guardaRopa.guardarPrendas(List.of(new Prenda("Nike", "jdkas"), new Prenda("Adidas", "jkfhgorhg")));
        guardaRopa.mostrarPrendas();
        //guardaRopa.devolverPrendas(id);

        //Escenario 2
        guardaRopa.guardarPrendas(List.of(new Prenda("Nikewww", "jdkas 2")));
        System.out.println(guardaRopa.devolverPrendas(3));
        guardaRopa.mostrarPrendas();

        //Remover prendas del escenario 1
        guardaRopa.quitarPrendas(id);
        guardaRopa.mostrarPrendas();
    }
}