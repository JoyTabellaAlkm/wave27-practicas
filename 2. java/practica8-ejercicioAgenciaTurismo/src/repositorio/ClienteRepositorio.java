package repositorio;

import modelo.Cliente;
import modelo.Reserva;
import modelo.Localizador;
import enums.TipoReserva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClienteRepositorio {
    Map<String, Cliente> listaClientes = new HashMap<>();
    List<Localizador> listaLocalizadores = new ArrayList<>();

    public void saveLocalizador(Localizador localizador){
        Cliente cliente = localizador.getCliente();
        if(!listaClientes.containsKey(cliente.getDni())){
            listaClientes.put(cliente.getDni(), cliente);
        }

        listaLocalizadores.add(this.solicitarDescuento(localizador));
    }

    public void deleteLocalizador(Localizador localizador){
        listaClientes.remove(localizador);
    }

    public List<Localizador> getListaLocalizadoresCliente(Cliente cliente){
        return this.listaLocalizadores.stream()
                .filter(localizador -> localizador.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

    public Localizador solicitarDescuento(Localizador localizador){
        List<Localizador> listaLocalizadores = getListaLocalizadoresCliente(localizador.getCliente());
        double totalDescuento = 0;

        if(listaLocalizadores.size() >= 2){
            totalDescuento += 0.05;
        }

        boolean paqueteCompleto = localizador.getListaReserva().stream()
                .map(Reserva:: getTipoReserva)
                .collect(Collectors.toSet())
                .contains(TipoReserva.PAQUETE_COMPLETO);

        if(paqueteCompleto){
            totalDescuento += 0.1;
        }

        long cuentaHotel = localizador.getListaReserva().stream()
                .filter(localizado -> localizado.getTipoReserva().equals(TipoReserva.HOTEL))
                .count();
        long cuentaBoleto = localizador.getListaReserva().stream()
                .filter(localizado -> localizado.getTipoReserva().equals(TipoReserva.BOLETO))
                .count();
        if(cuentaHotel >= 2 || cuentaBoleto >= 2){
            for(Reserva reserva : localizador.getListaReserva()){
                if (reserva.getTipoReserva().equals(TipoReserva.HOTEL) || reserva.getTipoReserva().equals(TipoReserva.BOLETO)){
                    double descuento = reserva.getPrecioReserva() * 0.95;
                    reserva.setPrecioReserva(descuento);
                }
            }

            localizador.calcularTotal();
        }

        localizador.setTotal(localizador.getTotal() - localizador.getTotal() * totalDescuento);

        return localizador;
    }
}
