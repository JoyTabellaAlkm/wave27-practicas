package org.bootcamp.series;

import lombok.Setter;

public abstract class SerieNumerica<T extends Number> {
    @Setter
    protected T numeroInicial;
    protected T numeroActual;
    protected T incremento;

    public SerieNumerica(T numeroInicial, T incremento) {
        this.numeroInicial = numeroInicial;
        this.numeroActual = numeroInicial;
        this.incremento = incremento;
    }

    public SerieNumerica(T incremento) {
        this.numeroInicial = valorInicialDefault();
        this.numeroActual = numeroInicial;
        this.incremento = incremento;
    }

    public abstract T proximoNumero();

    public void reiniciar() {
        numeroActual = numeroInicial;
    }

    protected abstract T valorInicialDefault();
}
