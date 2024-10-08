import modelo.Cliente;
import modelo.Localizador;
import modelo.Reserva;
import enums.TipoReserva;
import repositorio.ClienteRepositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

        Cliente cliente = new Cliente("Martin", "Diaz", "123");

        Localizador localizador1 = new Localizador(cliente, Collections.singletonList(new Reserva("Vacaciones", TipoReserva.PAQUETE_COMPLETO, 200)));

        clienteRepositorio.saveLocalizador(localizador1);

        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva("Hotel 1", TipoReserva.HOTEL, 100.0));
        reservas.add(new Reserva("Hotel 2", TipoReserva.HOTEL, 150.0));
        reservas.add(new Reserva("Boleto 1", TipoReserva.BOLETO, 70.0));
        reservas.add(new Reserva("Boleto 2", TipoReserva.BOLETO, 50.0));

        Localizador localizador2 = new Localizador(cliente, reservas);

        clienteRepositorio.saveLocalizador(localizador2);

        Localizador localizador3 = new Localizador(cliente, Collections.singletonList(new Reserva("Comida", TipoReserva.COMIDA, 500)));

        clienteRepositorio.saveLocalizador(localizador3);

        clienteRepositorio.getListaLocalizadoresCliente(cliente).forEach(System.out::println);
    }
}