package org.example;

import java.util.Date;

public class ReservaHotel extends Reserva{
    public ReservaHotel(Date fechaInicial, Date fechaFinal, Float precio, String descripcion) {
        super(fechaInicial, fechaFinal, precio, descripcion);
    }
}
