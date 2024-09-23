package ej2;

public class SerieDouble extends Prototipo<Double>{
    SerieDouble(Double paso){
        super(paso);
    }
    @Override
    public Double siguienteValor() {
        Double valorSiguiente = valorActual;
        valorActual += paso;
        return valorSiguiente;
    }
}
