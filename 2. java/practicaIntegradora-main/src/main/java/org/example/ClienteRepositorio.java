package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClienteRepositorio {

    Map<String, Cliente> listaClientes = new HashMap<>();
    List<Localizador> listaLocalizadores = new ArrayList<>();


    public void saveLocalizador(Localizador localizador){

        Cliente cliente =  localizador.getCliente();

        if (!listaClientes.containsKey(cliente.getDni())){
            listaClientes.put(cliente.getDni(), cliente);
        }
        aplicarDescuento(localizador);
        listaLocalizadores.add(localizador);
    }

    public void deleteLocalizador(Localizador localizador){
        listaLocalizadores.remove(localizador);
    }

    public List<Localizador> getListaLocalizadoresCliente(Cliente cliente){
        return this.listaLocalizadores.stream()
                .filter(localizador -> localizador.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

    public void aplicarDescuento(Localizador localizador){

        List<Localizador> listaLocalizadores = getListaLocalizadoresCliente(localizador.getCliente());
        Double totalDescuento;

        //Descuento del 5% por mas de 2 localizadores
        if (listaLocalizadores.size() > 2) {
            totalDescuento = localizador.getTotal() * 0.95;
            localizador.setTotal(totalDescuento);
            return;
        }

        Boolean paqueteCompleto = localizador.getListaReserva().stream()
                .map(Reserva::getTipoReserva)
                .collect(Collectors.toSet())
                .contains(TipoReserva.PAQUETE_COMPLETO);

        //Adquiere paquete completp
        if (paqueteCompleto){
            totalDescuento = localizador.getTotal() * 0.9;
            localizador.setTotal(totalDescuento);
            return;
        }

        long cuentaHotel = localizador.getListaReserva().stream()
                .filter(localizado -> localizado.getTipoReserva().equals(TipoReserva.HOTEL))
                .count();

        long cuentaBoleto = localizador.getListaReserva().stream()
                .filter(localizado -> localizado.getTipoReserva().equals(TipoReserva.BOLETO))
                .count();

        //Descuento del 5% para cada reserva si tiene 2 o mas Hotel o Boleto
        if (cuentaHotel >= 2 || cuentaBoleto >= 2){
            for (Reserva reserva: localizador.getListaReserva()){
                if (reserva.getTipoReserva().equals(TipoReserva.HOTEL) || reserva.getTipoReserva().equals(TipoReserva.BOLETO)){
                    Double descuento = reserva.getPrecioReserva() * 0.95;
                    reserva.setPrecioReserva(descuento);
                }
            }
            localizador.calcularTotal();
        }


    }

}
