package repository;

import modelos.Cliente;
import modelos.Localizador;
import modelos.Reserva;
import modelos.TipoReserva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientRepository {
    private List<Localizador> localizadores = new ArrayList<>();
    private Map<String, Cliente> listaClientes = new HashMap<>();

    public void saveLocalizador(Localizador localizador) {
        Cliente cliente = localizador.getCliente();

        if (!listaClientes.containsKey(cliente.getDni())) {
            listaClientes.put(cliente.getDni(), cliente);
        }

        localizador.calcularTotal();
        localizadores.add(localizador);
    }

    public void deleteLocalizador(Localizador localizador) {
        localizadores.remove(localizador);
    }

    public List<Localizador> getLocalizadoresPorCliente(Cliente cliente) {
        return localizadores.stream()
                .filter(local -> local.getCliente().equals(cliente))
                .toList();
    }

    public void aplicarDescuento(Localizador localizador) {
        List<Localizador> listaLocalizadoresCliente = getLocalizadoresPorCliente(localizador.getCliente());
        double totalDescuento;

        if (listaLocalizadoresCliente.size() >= 2) {
            totalDescuento = localizador.getTotal() * 0.95;
            localizador.setTotal(totalDescuento);
        }

        boolean esPaqueteCompleto = listaLocalizadoresCliente.stream().anyMatch(Localizador::contienePaqueteCompleto);

        if (esPaqueteCompleto) {
            totalDescuento = localizador.getTotal() * 0.90;
            localizador.setTotal(totalDescuento);
        }

        long cantReservasBoleto = localizador.contarReservasPorTipo(TipoReserva.BOLETO);
        long cantReservasHotel = localizador.contarReservasPorTipo(TipoReserva.HOTEL);

        if (cantReservasHotel >= 2 || cantReservasBoleto >= 2) {
            for (Reserva reserva : localizador.getReservas()) {
                if (reserva.getTipoReserva() == TipoReserva.BOLETO || reserva.getTipoReserva() == TipoReserva.HOTEL) {
                    double precioReserva = reserva.getPrecio();
                    reserva.setPrecio(precioReserva * 0.95);
                }
            }

            localizador.calcularTotal();
        }
    }
}
