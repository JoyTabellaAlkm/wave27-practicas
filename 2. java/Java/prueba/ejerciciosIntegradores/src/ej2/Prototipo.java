package ej2;

public abstract class Prototipo<T extends Number> {
    protected T paso;
    protected T valorActual;

    public Prototipo(T paso) {
        this.paso = paso;
        this.valorActual = paso;
    }

    public abstract T siguienteValor();

    public void reiniciarSerie() {
        this.valorActual = paso;
    }

    public void establecerValorInicial(T valorInicial) {
        this.valorActual = valorInicial;
    }
}
