package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;

    private List<Localizador> listaLocalizadores;

    public Cliente() {
    }

    public Cliente(String nombre) {

        this.nombre = nombre;

        this.listaLocalizadores = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }


    public List<Localizador> getListaLocalizadores() {
        return listaLocalizadores;
    }

    public void setListaLocalizadores(List<Localizador> listaLocalizadores) {
        this.listaLocalizadores = listaLocalizadores;
    }
public void agregarLocalizador(Localizador localizador){
        listaLocalizadores.add(localizador);
}
    public int contarLocalizadores(){
        return listaLocalizadores.size();
    }

    public boolean haAdquiridoPaqueteCompleto(){
        return listaLocalizadores.stream().anyMatch(localizador -> localizador.getListaReservas().stream().map(Reserva::getTipo).distinct().count() == 4);
    }
    public boolean haAdquiridoDosReservasTipo(String tipo){
        long count= listaLocalizadores.stream().flatMap(localizador ->  localizador.getListaReservas().stream())
                .filter(reserva -> reserva.getTipo().equals(tipo)).count();
        return count >=2;
    }
}
