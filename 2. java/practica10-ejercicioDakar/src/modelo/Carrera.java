package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Carrera {
    private double distancia;
    private long premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;

    public Carrera(double distancia, long premioEnDolares, String nombre, int cantidadVehiculosPermitidos, List<Vehiculo> listaVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.listaVehiculos = listaVehiculos;
    }

    public void darDeAltaAuto(double velocidad, int aceleracion, int anguloDeGiro, String patente){
        listaVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(double velocidad, int aceleracion, int anguloDeGiro, String patente){
        listaVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        listaVehiculos.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        this.listaVehiculos = listaVehiculos.stream().filter(l -> !l.getPatente().equals(unaPatente)).collect(Collectors.toList());
    }

    public Vehiculo obtenerAutoGanador(){
        List<Auto> listaAutos = listaVehiculos.stream()
                .filter(a -> a instanceof Auto)
                .map(a -> (Auto) a)
                .toList();
        Map<Auto, Double> promedioVelocidad = listaAutos.stream()
                .collect(Collectors.toMap(
                        (a) -> a,
                        (b) -> (b.getVelocidad() * (1/2 * b.getAceleracion())) / (b.getAnguloDeGiro() * ((b.getPeso() - b.getRuedas()) * 100))
                ));
        Auto ganador = promedioVelocidad.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        return ganador;
    }


    //Getter&Setter
    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public long getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(long premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}
