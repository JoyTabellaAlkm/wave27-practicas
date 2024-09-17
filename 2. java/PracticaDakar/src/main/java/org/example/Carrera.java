package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadVehiculosPermitida;
    private List<Vehiculo> listaVehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadVehiculosPermitida, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitida = cantidadVehiculosPermitida;
        this.listaVehiculos = listaVehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double angulo, String patente){
        if (this.listaVehiculos.size() < cantidadVehiculosPermitida) {
            listaVehiculos.add(new Auto(velocidad, aceleracion, angulo, patente));
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double angulo, String patente){
        if (this.listaVehiculos.size() < cantidadVehiculosPermitida) {
            listaVehiculos.add(new Moto(velocidad, aceleracion, angulo, patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaVehiculos.remove(vehiculo);
    }

    public Vehiculo getVehiculoPatente(String patente){
        return listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
    }

    public void eliminarVehiculoConPatente(String patente){
        listaVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public Double calcularScore(Vehiculo vehiculo){

        Double score =  (vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion()) /
                ((vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100)));
        System.out.println("Para el vehiculo: " + vehiculo.getPatente() + " el score fue de: " + score);

        return score;
    }

    public Vehiculo verGanador(){
        return this.listaVehiculos.stream()
                .max(Comparator.comparingDouble(this::calcularScore))
                .orElse(null);
    }

    public void socorrerAuto(String patente){
        Vehiculo vehiculo = getVehiculoPatente(patente);
        this.socorristaAuto.socorrer((Auto) vehiculo);
    }

    public void socorrerMoto(String patente){
        Vehiculo vehiculo = getVehiculoPatente(patente);
        this.socorristaMoto.socorrer((Moto) vehiculo);
    }
}
