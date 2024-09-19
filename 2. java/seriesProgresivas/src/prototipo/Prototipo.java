package prototipo;

public abstract class Prototipo<T extends Number> {
    private T valor;
    private T serie;

    public Prototipo(T serie) {
        valor = setValorEnCero();
        this.serie = serie;
    }

    protected T setValorEnCero() {
        return (T) Integer.valueOf(0);
    }

    public void reiniciar() {
        valor = setValorEnCero();
    }

    public T siguienteValor() {
        return valor = devolverValorSiguiente(valor, serie);
    }

    public abstract T devolverValorSiguiente(T num1, T num2);
    protected abstract void setValorInicial(T num);
}
