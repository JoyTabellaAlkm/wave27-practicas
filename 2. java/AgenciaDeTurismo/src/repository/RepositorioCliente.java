package repository;

import model.Cliente;
import model.Localizador;
import model.Reserva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioCliente {
    List<Localizador> listaLocalizadores;
    private Map<String, Cliente> clientes;

    public RepositorioCliente(){
        clientes = new HashMap<>();
    }
    public Cliente buscarCliente(String nombre){
        return clientes.get(nombre);
    }
    public void agregarCliente(Cliente cliente){
        clientes.put(cliente.getNombre(),cliente);
    }
    public void agregarLocalizador(String nombreCliente, Localizador localizador)
    {
        Cliente cliente = clientes.get(nombreCliente);
        if(cliente == null){
            cliente = new Cliente(nombreCliente);
            clientes.put(nombreCliente, cliente);
        }
    }
    public int cantidadLocalizadoresVendidos(){
        return clientes.values().stream().mapToInt(cliente -> cliente.getListaLocalizadores().size()).sum();

    }

    public int cantidadTotalReservas(){
        return clientes.values().stream()
                .flatMap(cliente -> cliente.getListaLocalizadores().stream())
                .flatMap(localizador -> localizador.getListaReservas().stream())
                .mapToInt(reserva -> 1).sum();
    }
    public Map<String, List<Reserva>> obtenerReservasClasificadas(){
        Map<String, List<Reserva>> reservasClasificadas = new HashMap<>();
        for(String tipo: new String[]{"hotel", "boleto","comida", "transporte"}){
    reservasClasificadas.put(tipo,new ArrayList<>());
        }
        clientes.values().stream()
                .flatMap(cliente -> cliente.getListaLocalizadores().stream())
                .flatMap(localizador -> localizador.getListaReservas().stream())
                .forEach(reserva -> reservasClasificadas.get(reserva.getTipo()).add(reserva));
                return reservasClasificadas;
    }
}
