package impresora;

import interfaces.Imprimible;

public class Impresora {
    public static void imprimirDocumento(Imprimible doc) {
        doc.imprimir();
    }
}
