package Imprimibles;

public interface iImprimible {
    public void imprimir();

    static void imprimirDocumento(iImprimible documento) {
        documento.imprimir();
    }
}
