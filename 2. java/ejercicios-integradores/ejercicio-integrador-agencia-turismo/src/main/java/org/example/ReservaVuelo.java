package org.example;

import java.util.Date;

public class ReservaVuelo extends Reserva
{
    public ReservaVuelo(Date fechaInicial, Date fechaFinal, Float precio, String descripcion) {
        super(fechaInicial, fechaFinal, precio, descripcion);
    }
}
