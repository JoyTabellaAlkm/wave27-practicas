package org.bootcamp;

import org.bootcamp.model.Cliente;
import org.bootcamp.model.Localizador;
import org.bootcamp.model.Reserva;
import org.bootcamp.model.TipoDeReserva;
import org.bootcamp.repository.LocalizadorRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1.1
        Cliente pepe = new Cliente("Pepe");
        LocalizadorRepository.addLocalizador(new Localizador(pepe, List.of(new Reserva(TipoDeReserva.BOLETOS, "Vuelo a Roma", 1300))));

        // 1.2
        Cliente juan = new Cliente("Juan");
        List<Reserva> reservasJuan = List.of(
                new Reserva(TipoDeReserva.BOLETOS, "Vuelo a Salta", 300),
                new Reserva(TipoDeReserva.HOTEL, "Hotel en Salta", 100),
                new Reserva(TipoDeReserva.BOLETOS, "Vuelo a Tucumán", 400),
                new Reserva(TipoDeReserva.HOTEL, "Hotel en Tucumán", 130)
        );
        LocalizadorRepository.addLocalizador(new Localizador(juan, reservasJuan));

        // 1.3
        Cliente maria = new Cliente("Maria");
        LocalizadorRepository.addLocalizador(new Localizador(maria, List.of(new Reserva(TipoDeReserva.BOLETOS, "Vuelo a Madrid", 1500))));
    }
}