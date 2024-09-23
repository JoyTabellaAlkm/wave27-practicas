package ej5;

import ej5.classes.GuardaRopa;
import ej5.classes.Prenda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Zara", "Remera");
        Prenda prenda2 = new Prenda("Nike", "Air force");

        List<Prenda> prendas = new ArrayList<>(Arrays.asList(prenda1));
        List<Prenda> prendas1 = new ArrayList<>(Arrays.asList(prenda2));
        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(prendas);
        guardaRopa.guardarPrendas(prendas1);
        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrendas(0));
        guardaRopa.mostrarPrendas();


    }
}
