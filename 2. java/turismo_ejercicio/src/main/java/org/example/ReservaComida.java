package org.example;

import java.util.Date;

public class ReservaComida extends Reserva{
    public ReservaComida(Date fechaInicial, Date fechaFinal, Float precio, String descripcion) {
        super(fechaInicial, fechaFinal, precio, descripcion);
    }
}
