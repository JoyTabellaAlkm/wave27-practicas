package impresora;

public class Imprenta {

    public static void main(String[] args) {

        Curriculum cv = new Curriculum();
        LibroPDF libro = new LibroPDF();
        Informe informe = new Informe();

        IImprimir.imprimirDocumento(cv);
        IImprimir.imprimirDocumento(libro);
        IImprimir.imprimirDocumento(informe);



    }
}
