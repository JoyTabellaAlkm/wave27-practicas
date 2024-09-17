package ClasesAbstractasLandas.Ejercicio2;

import ClasesAbstractasLandas.Ejercicio2.Documentos.Curriculum;
import ClasesAbstractasLandas.Ejercicio2.Documentos.Imprimir;
import ClasesAbstractasLandas.Ejercicio2.Documentos.Informe;
import ClasesAbstractasLandas.Ejercicio2.Documentos.Libro;

import java.util.LinkedList;
import java.util.List;

public class MainEJ2 {

    public static void main (String[] args){
        Imprimir libro = new Libro();

        Imprimir informe = new Informe();

        Imprimir curriculum = new Curriculum();

        List<Imprimir> documentos = new LinkedList<>();

        documentos.add(libro);
        documentos.add(informe);
        documentos.add(curriculum);

        documentos.stream().forEach(imprimible -> imprimible.imprimir());

    }

}
