import Imprimibles.Curriculum;
import Imprimibles.Informe;
import Imprimibles.Libro;
import Imprimibles.iImprimible;

public class Main {
    public static void main(String[] args) {

        Libro libro = new Libro();
        Curriculum curriculum = new Curriculum();
        Informe informe = new Informe();

        iImprimible.imprimirDocumento(libro);
    }
}