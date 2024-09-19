import modelos.Cliente;
import modelos.Localizador;
import modelos.Reserva;
import modelos.TipoReserva;
import repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cliente martin = new Cliente("Martin", "Diaz", "123");
        Cliente lean = new Cliente("Lean", "Ramirez", "321");
        Cliente leidy = new Cliente("Leidy", "Rodas", "456");

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

        ClientRepository repo = new ClientRepository();

        repo.saveLocalizador(localizador1);
        repo.aplicarDescuento(localizador1);

        repo.saveLocalizador(localizador2);
        repo.aplicarDescuento(localizador2);

        repo.saveLocalizador(localizador3);
        repo.aplicarDescuento(localizador3);

        System.out.println(localizador1);
        System.out.println(localizador2);
        System.out.println(localizador3);
    }
}
