package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos = new ArrayList<>();
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera() {
    }

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(listaDeVehiculos.size()< cantidadDeVehiculosPermitidos || listaDeVehiculos.isEmpty()){
            listaDeVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
        }else{
            System.out.println("Cupos de la carrera llenos.");
        }
    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(listaDeVehiculos.size()< cantidadDeVehiculosPermitidos || listaDeVehiculos.isEmpty()){
            listaDeVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
        }else{
            System.out.println("Cupos de la carrera llenos.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
    listaDeVehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente){
       Optional<Vehiculo> vehiculoEliminar = listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst();
       if(vehiculoEliminar.isPresent()){
           System.out.println("Vehiculo eliminado.");
           listaDeVehiculos.remove(vehiculoEliminar.get());
       }else{
           System.out.println("Vehiculo no encontrado.");
       }
    }

    public void definirGanador() {
Optional<Vehiculo> vehiculoGanador = listaDeVehiculos.stream().max((v1,v2)  -> Double.compare(calcularValor(v1), calcularValor(v2)));
vehiculoGanador.ifPresentOrElse(v-> System.out.println("El vehiculo ganador es: " + v + " con el valor: " + calcularValor(v)),
        ()-> System.out.println("No se pudo determinar un ganador."));


    }
    public double calcularValor(Vehiculo vehiculo){
        double velocidad = vehiculo.getVelocidad();
        double aceleracion = vehiculo.getAceleracion();
        double anguloDeGiro = vehiculo.getAnguloDeGiro();
        double peso = vehiculo.getPeso();
        int ruedas = vehiculo.getRuedas();

        double denominador = anguloDeGiro * (peso - ruedas * 100);

        return (velocidad * 0.5 * aceleracion) / denominador;
    }

    public void socorrerAuto(String patente){
        Optional<Vehiculo> auto = listaDeVehiculos.stream().filter(vehiculo -> vehiculo instanceof Auto && vehiculo.getPatente().equals(patente)).findFirst();
    if(auto.isPresent()){
        socorristaAuto.socorrer((Auto)auto.get());
    }else{
        System.out.println("Auto no encontrado.");
    }
    }
    public void socorrerMoto (String patente){
        Optional<Vehiculo> moto = listaDeVehiculos.stream().filter(vehiculo -> vehiculo instanceof Moto && vehiculo.getPatente().equals(patente)).findFirst();
        if(moto.isPresent()){
            socorristaMoto.socorrer((Moto)moto.get());
        }else{
            System.out.println("Moto no encontrada.");
        }
    }
}
