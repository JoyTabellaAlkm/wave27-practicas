package clases;

public class SerieGeometrica extends Prototipo<Double>{
    private double multiplicador;

    public SerieGeometrica(double multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public void siguiente() {
        valorActual *=  multiplicador;
        System.out.println(valorActual);
    }
}
