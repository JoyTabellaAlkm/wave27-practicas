public abstract class Prototipo {
    protected Integer numeroActual;
    protected static Integer numeroProximo;

    public Prototipo() {
        this.numeroActual = 0;
        this.numeroProximo = 0;
    }

    public Integer devolverNumero() {
         numeroProximo += 1;
         return  numeroProximo;
    }

    public void reiniciarSerie() {
        numeroProximo = numeroActual;
    }

    public void establecerValorInicial(Integer valorInicial) {
        numeroProximo = valorInicial;
    }
}
