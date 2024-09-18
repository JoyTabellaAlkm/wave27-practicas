package clases;

public abstract class Prototipo<T extends Number> {
    protected T valorActual;
    protected T valorInicial;

    public Prototipo() {
    }

    public Prototipo(T valorActual, T valorInicial) {
        this.valorActual = valorActual;
        this.valorInicial = valorInicial;
    }

    public void establecerValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    public abstract void siguiente();


public void reiniciar(){
    valorActual = valorInicial;
}

}
