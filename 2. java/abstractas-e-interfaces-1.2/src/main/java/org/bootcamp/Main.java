package org.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Imprimible>  imprimibles = new ArrayList<>(Arrays.asList(
            new LibroPDF(100, "Juan Perez", "Progamación Java", "Programación"),
            new Informe("Esto es un informe largo", 150, "Yo", "Nadie"),
            new Curriculum(new Persona(
                    "Jorge Martínez",
                    new ArrayList<>(Arrays.asList("Un atributo", "Otro atributo")),
                    new ArrayList<>(Arrays.asList("Una habilidad", "Otra habilidad"))
            ))
        ));

        imprimibles.forEach(Imprimible::imprimir);
    }
}