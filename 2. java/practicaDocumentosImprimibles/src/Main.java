import documentos.Curriculum;
import documentos.Genero;
import documentos.Informe;
import documentos.Libro;
import impresora.Impresora;
import personas.Autor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Libro libro = new Libro(120, "Harry Potter", "J. K. Rowghling", Genero.FANTASIA);
        Informe informe = new Informe();
        Curriculum cv = new Curriculum();

        Impresora.imprimirDocumento(libro);
        Impresora.imprimirDocumento(informe);
        Impresora.imprimirDocumento(cv);

    }
}