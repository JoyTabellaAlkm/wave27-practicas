package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reserva {
    private String nombre;
    private TipoReserva tipoReserva;
    private Double precioReserva;
}
