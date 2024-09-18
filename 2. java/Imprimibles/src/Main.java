import clases.Informe;
import clases.LibroPDF;
import interfaces.IImprimible;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IImprimible> imprimibles = new ArrayList<>(Arrays.asList(
                new LibroPDF(100, "Luis Rodriguez", "Git Basico", "Desarrollo en equipo"),
                new Informe("Prueba de informe", 100, "Javier Perez", "Maria Ayala"),
                new LibroPDF(200, "Marcos Fernandez", "Cuento 4", "Fantasia")
        ));

        imprimibles.get(0).imprimir();
        imprimibles.get(1).imprimir();
        imprimibles.get(2).imprimir();
    }

}