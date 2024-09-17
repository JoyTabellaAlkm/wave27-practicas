package org.bootcamp.model;

import lombok.ToString;

@ToString
public class DescuentoPorcentual implements Descuento {
    private double porcentaje;

    public DescuentoPorcentual(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double aplicar(double total) {
        return total * (1 - porcentaje / 100);
    }
}
