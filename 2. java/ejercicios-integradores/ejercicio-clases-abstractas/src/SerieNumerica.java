public abstract class SerieNumerica<T extends Number> {
    protected T valorInicial;
    protected int incremento;
    protected int contador;

    public SerieNumerica(T valorInicial, int incremento) {
        this.valorInicial = valorInicial;
        this.incremento = incremento;
        this.contador = 0;
    }

    public T devolverValorSiguiente(){
        T resultado = calcularValor(contador);
        contador++;
        return resultado;
    }
    public void reiniciarSerie() {
        contador = 0;
    }
    public void establecerValorInicial(T nuevoValor) {
        this.valorInicial = nuevoValor;
        this.contador = 0; // Reiniciar el contador al establecer un nuevo valor inicial
    }

    protected abstract T calcularValor(int contador);

}
