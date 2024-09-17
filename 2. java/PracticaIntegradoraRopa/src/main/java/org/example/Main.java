package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear instancias de Prenda
        Prenda prenda1 = new Prenda("Adidas", "Predator");
        Prenda prenda2 = new Prenda("Nike", "Air Force 1");

        // Crear una lista de prendas
        List<Prenda> listaPrendas = Arrays.asList(prenda1, prenda2);
        List<Prenda> listaPrendas2 = List.of(prenda1);


        // Crear una instancia de GuardaRopa
        GuardaRopa guardaRopa = new GuardaRopa();

        // Guardar las prendas y recibir el código
        Integer codigo = guardaRopa.guardarPrendas(listaPrendas);
        System.out.println("Código de prendas guardadas: " + codigo);

        Integer codigo2 = guardaRopa.guardarPrendas(listaPrendas2);
        System.out.println("Código de prendas guardadas: " + codigo2);

        // Consultar por las prendas guardadas usando el código
        List<Prenda> prendasGuardadas = guardaRopa.devolverPrendas(codigo);
        System.out.println("Prendas guardadas: " + prendasGuardadas);

    }
}