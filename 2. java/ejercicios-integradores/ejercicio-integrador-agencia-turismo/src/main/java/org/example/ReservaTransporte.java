package org.example;

import java.util.Date;

public class ReservaTransporte extends Reserva{
    public ReservaTransporte(Date fechaInicial, Date fechaFinal, Float precio, String descripcion) {
        super(fechaInicial, fechaFinal, precio, descripcion);
    }
}
