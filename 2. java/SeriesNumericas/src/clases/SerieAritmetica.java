package clases;

public class SerieAritmetica extends Prototipo<Integer>{
private int incremento;

    public SerieAritmetica(int incremento) {
        this.incremento = incremento;
    }

    @Override
    public void siguiente() {
        valorActual += incremento;
        System.out.println(valorActual);
    }


}
