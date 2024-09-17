package org.bootcamp.repository;

import lombok.Getter;
import org.bootcamp.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LocalizadorRepository {
    @Getter
    private static List<Localizador> localizadores = new ArrayList<>();

    public static void addLocalizador(Localizador localizador) {
        applyDiscounts(localizador);
        System.out.println("Localizador added: " + localizador);
        localizadores.add(localizador);
    }

    private static void applyDiscounts(Localizador localizador) {
        if (getLocalizadoresByCliente(localizador.getCliente()).count() >= 2)
            localizador.agregarDescuento(new DescuentoPorcentual(5));

        if (localizador.tienePaqueteCompleto())
            localizador.agregarDescuento(new DescuentoPorcentual(10));

        List<Reserva> reservasDeHotel = localizador.getReservas().stream().filter(reserva -> reserva.getTipo().equals(TipoDeReserva.HOTEL)).toList();
        if (reservasDeHotel.size() >= 2) {
            reservasDeHotel.forEach(reserva -> reserva.agregarDescuento(new DescuentoPorcentual(5)));
        }

        List<Reserva> reservasDeBoletos = localizador.getReservas().stream().filter(reserva -> reserva.getTipo().equals(TipoDeReserva.BOLETOS)).toList();
        if (reservasDeBoletos.size() >= 2) {
            reservasDeBoletos.forEach(reserva -> reserva.agregarDescuento(new DescuentoPorcentual(5)));
        }
    }

    private static Stream<Localizador> getLocalizadoresByCliente(Cliente cliente) {
        return localizadores.stream().filter(localizador -> localizador.getCliente().equals(cliente));
    }
}
