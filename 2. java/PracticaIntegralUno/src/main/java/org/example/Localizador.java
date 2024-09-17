package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Localizador {
    private Cliente cliente;
    private List<Reserva> servicio;
    private Double total;


}
