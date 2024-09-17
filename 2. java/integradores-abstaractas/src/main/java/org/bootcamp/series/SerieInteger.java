package org.bootcamp.series;

public class SerieInteger extends SerieNumerica<Integer> {
    public SerieInteger(Integer numeroInicial, Integer incremento) {
        super(numeroInicial, incremento);
    }

    public SerieInteger(Integer incremento) {
        super(incremento);
    }

    @Override
    public Integer proximoNumero() {
        numeroActual += incremento;
        return numeroActual;
    }

    @Override
    protected Integer valorInicialDefault() {
        return 0;
    }
}
