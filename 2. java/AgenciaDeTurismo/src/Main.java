import model.Cliente;
import model.Localizador;
import model.Reserva;
import repository.RepositorioCliente;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositorioCliente repoCliente = new RepositorioCliente();

        List<Reserva> reservasPaqueteCompleto = List.of(
                new Reserva("hotel",100),
                new Reserva("comida", 50),
                new Reserva("boleto",200),
                new Reserva("transporte",30)
        );
        Localizador localizador1 = new Localizador("Leandro", reservasPaqueteCompleto);
        repoCliente.agregarLocalizador("Leandro",localizador1);

        List<Reserva> reservasParcial = List.of(
                new Reserva("hotel",100),
                new Reserva("hotel", 150),
                new Reserva("boleto",200),
                new Reserva("boleto",170)
        );

        Localizador localizador2 = new Localizador("Leandro", reservasParcial);
        repoCliente.agregarLocalizador("Leandro", localizador2);

        List<Reserva> reservaUnica  = List.of(new Reserva("comida", 60));
        Localizador localizador3 = new Localizador("Leandro",reservaUnica);
        repoCliente.agregarLocalizador("Leandro", localizador3);

        Cliente cliente = repoCliente.buscarCliente("Leandro");
        cliente.getListaLocalizadores().forEach(localizador -> {
            if(cliente.contarLocalizadores() >= 2){
                localizador.aplicarDescuento(5);
            }
            if(cliente.haAdquiridoPaqueteCompleto()){
                localizador.aplicarDescuento(10);
            }
            if (cliente.haAdquiridoDosReservasTipo("hotel") || cliente.haAdquiridoDosReservasTipo("boleto"))
            {
                localizador.getListaReservas().stream()
                        .filter(reserva -> reserva.getTipo().equals("hotel") || reserva.getTipo().equals("boleto"))
                        .forEach(reserva -> localizador.aplicarDescuento(5));
            }
            System.out.println(localizador);
        });

        System.out.println("Cantidad de localizadores vendidos: " + repoCliente.cantidadLocalizadoresVendidos());
        System.out.println("Cantidad total de reservas: " + repoCliente.cantidadTotalReservas());
        System.out.println("Reservas clasificadas: " + repoCliente.obtenerReservasClasificadas());
    }
}