import documentos.Curriculums;
import documentos.Libro;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> habilidades = new ArrayList<>();

        habilidades.add("Alegre");
        habilidades.add("Inteligente");
        Curriculums c1 = new Curriculums("Salome", habilidades);
        Libro l1 = new Libro(2);

        Imprimir.impresion(c1);
        Imprimir.impresion(l1);
    }
}