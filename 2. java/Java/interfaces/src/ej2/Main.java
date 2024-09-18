package ej2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> habilidad = new ArrayList<>();
        habilidad.add("Cocinar");
        habilidad.add("Estudiar");
        habilidad.add("Programar");

        Curriculums curriculums = new Curriculums("Delfina", "Glavas", 44432904, 357253,
                habilidad);

        Informes informes = new Informes("sdaaskdalds", 2, "Gabriel Garcia Marquez", "Revisor");

        Libros libros = new Libros(4, "Mariana", "Una pulga aventurera", "Terror");

        Impresion.imprimirContenido(curriculums);
        Impresion.imprimirContenido(informes);
        Impresion.imprimirContenido(libros);


    }
}
