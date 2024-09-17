package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClienteRepositorio {
    private Map<String, Cliente> clientes = new HashMap<>();
    @Getter
    private List<Localizador> localizadores = new ArrayList<>();

    public void saveLocalizador(Localizador localizador) {
        Cliente cliente = localizador.getCliente();

        if (!clientes.containsKey(cliente.getDni())) {
            clientes.put(cliente.getDni(), cliente);
        }

        localizadores.add(localizador);
    }

    public List<Localizador> getLocalizadoresByCliente(Cliente cliente) {
        return localizadores.stream()
                .filter(localizador -> localizador.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

    public double aplicarDescuentos(Localizador localizador) {
        Cliente cliente = localizador.getCliente();
        List<Localizador> reservasCliente = getLocalizadoresByCliente(cliente);

        double total = localizador.getTotal();

        // Descuento por 2 localizadores anteriores
        if (reservasCliente.size() >= 2) {
            total *= 0.95;
        }

        // Descuento por paquete completo
        boolean paqueteCompleto = localizador.getServicio().stream()
                .map(Reserva::getNombre)
                .collect(Collectors.toSet())
                .contains("Paquete completo");

        if (paqueteCompleto) {
            total *= 0.90;
        }

        // Descuento por 2 reservas de hotel o 2 boletos de viaje
        long countHotel = localizador.getServicio().stream()
                .filter(reserva -> reserva.getNombre().equals("Hotel"))
                .count();

        long countBoletos = localizador.getServicio().stream()
                .filter(reserva -> reserva.getNombre().equals("Boletos"))
                .count();

        if (countHotel >= 2 || countBoletos >= 2) {
            total *= 0.95;
        }

        // Actualizar el total del localizador
        localizador.setTotal(total);

        return total;
    }
}
