package ej2;

public class SerieEntero extends Prototipo<Integer>{
    public SerieEntero(Integer paso){
        super(paso);
    }

    @Override
    public Integer siguienteValor() {
        Integer valorSiguiente = valorActual;
        valorActual += paso;
        return valorSiguiente;
    }

}
