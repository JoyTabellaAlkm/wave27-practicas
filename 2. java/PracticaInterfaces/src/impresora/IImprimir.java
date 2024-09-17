package impresora;

public interface IImprimir {
    void imprimir();

    static void imprimirDocumento(IImprimir documento) {
        documento.imprimir();
    }
}
