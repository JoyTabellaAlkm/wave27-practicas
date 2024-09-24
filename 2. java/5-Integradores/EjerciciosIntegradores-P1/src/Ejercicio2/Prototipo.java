package Ejercicio2;

public abstract class Prototipo <T extends Number>{

    private T valorInicial;
    private  T valorActual;
    private T incremento;

    public T valorSiguiente(){
        valorActual = sumar(valorActual, incremento);
        return valorActual;
    }

    protected abstract T sumar(T a, T b);

    public void reiniciarSerie(){
        valorActual = valorInicial;
    }

    public void setValorInicial(T valor){
        this.valorInicial = valor;
        reiniciarSerie();
    }
}
