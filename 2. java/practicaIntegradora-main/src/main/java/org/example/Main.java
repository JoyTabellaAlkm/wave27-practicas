package org.example;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Cliente martin = new Cliente("Martin", "Diaz", "123");
        Cliente lean = new Cliente("Lean", "Ramirez", "321");
        Cliente leidy = new Cliente("leidy", "Rodas", "456");

        // Crear listas de reservas
        List<Reserva> reservasCliente1 = new ArrayList<>();

        reservasCliente1.add(new Reserva("Reserva 1", TipoReserva.PAQUETE_COMPLETO, 100.0));

        List<Reserva> reservasCliente2 = new ArrayList<>();
        reservasCliente2.add(new Reserva("Reserva 3", TipoReserva.HOTEL, 200.0));
        reservasCliente2.add(new Reserva("Reserva 4", TipoReserva.HOTEL, 100.0));
        reservasCliente2.add(new Reserva("Reserva 5", TipoReserva.BOLETO, 100.0));
        reservasCliente2.add(new Reserva("Reserva 6", TipoReserva.BOLETO, 100.0));


        List<Reserva> reservasCliente3 = new ArrayList<>();
        reservasCliente3.add(new Reserva("Reserva 3", TipoReserva.TRANSPORTE, 200.0));

        // Crear instancias de Localizador
        Localizador localizador1 = new Localizador(martin, reservasCliente1);
        Localizador localizador2 = new Localizador(lean, reservasCliente2);
        Localizador localizador3 = new Localizador(leidy, reservasCliente3);

        ClienteRepositorio repo = new ClienteRepositorio();
        ClienteService service = new ClienteService(repo);

        repo.saveLocalizador(localizador1);

        repo.saveLocalizador(localizador2);

        repo.saveLocalizador(localizador3);

        service.mostrarLocalizadoresVendidos();
        service.mostrarReservasTotales();
        service.calcularTotal();
        service.calcularPromedioVenta();
    }



}