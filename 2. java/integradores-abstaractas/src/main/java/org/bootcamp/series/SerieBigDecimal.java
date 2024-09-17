package org.bootcamp.series;

import java.math.BigDecimal;

public class SerieBigDecimal extends SerieNumerica<BigDecimal> {
    public SerieBigDecimal(BigDecimal numeroInicial, BigDecimal incremento) {
        super(numeroInicial, incremento);
    }

    public SerieBigDecimal(BigDecimal incremento) {
        super(incremento);
    }

    @Override
    public BigDecimal proximoNumero() {
        numeroActual = numeroActual.add(incremento);
        return numeroActual;
    }

    @Override
    protected BigDecimal valorInicialDefault() {
        return BigDecimal.ZERO;
    }
}
