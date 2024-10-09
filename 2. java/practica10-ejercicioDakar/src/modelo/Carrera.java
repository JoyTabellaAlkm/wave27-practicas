package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Carrera {
    private double distancia;
    private long premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;
    private List<Socorrista> listaSocorrista;

    public Carrera(double distancia, long premioEnDolares, String nombre, int cantidadVehiculosPermitidos, List<Socorrista> listaSocorrista) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
        this.listaSocorrista = listaSocorrista;
    }

    public void darDeAltaAuto(double velocidad, int aceleracion, int anguloDeGiro, String patente){
        if (listaVehiculos.size() >= cantidadVehiculosPermitidos) throw new RuntimeException("Cantidad maxima de vehiculos permitida para esta carrera");
        listaVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(double velocidad, int aceleracion, int anguloDeGiro, String patente){
        if (listaVehiculos.size() >= cantidadVehiculosPermitidos) throw new RuntimeException("Cantidad maxima de vehiculos permitida para esta carrera");
        listaVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        listaVehiculos.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        this.listaVehiculos = listaVehiculos.stream().filter(l -> !l.getPatente().equals(unaPatente)).collect(Collectors.toList());
    }

    public Vehiculo obtenerGanador(){
        List<Auto> listaAutos = listaVehiculos.stream()
                .filter(a -> a instanceof Auto)
                .map(a -> (Auto) a)
                .toList();
        List<Moto> listaMotos = listaVehiculos.stream()
                .filter(a -> a instanceof Moto)
                .map(a -> (Moto) a)
                .toList();

        Map<? extends Auto, Double> promedioVelocidadAutos = listaAutos.stream()
                .collect(Collectors.toMap(
                        (a) -> a,
                        (b) -> (b.getVelocidad() * (b.getAceleracion()/2)) / (b.getAnguloDeGiro() * (b.getPeso() - b.getRuedas() * 100))
                ));
        Map<? extends Moto, Double> promedioVelocidadMotos = listaMotos.stream()
                .collect(Collectors.toMap(
                        (a) -> a,
                        (b) -> (b.getVelocidad() * (b.getAceleracion()/2)) / (b.getAnguloDeGiro() * (b.getPeso() - b.getRuedas() * 100))
                ));

        Auto ganadorauxAuto = promedioVelocidadAutos.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        Moto ganadorauxMoto = promedioVelocidadMotos.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        Double velocidadAuto = Optional.ofNullable(promedioVelocidadAutos.get(ganadorauxAuto)).orElse(0.0);
        Double velocidadMoto = Optional.ofNullable(promedioVelocidadMotos.get(ganadorauxMoto)).orElse(0.0);

        return velocidadAuto > velocidadMoto ? ganadorauxAuto : ganadorauxMoto;
    }

    // Socorristas
    public void socorrerAuto(String patente){
        SocorristaAuto socorristaAuto = listaSocorrista.stream()
                .filter(l -> l instanceof SocorristaAuto)
                .findAny()
                .map(l -> (SocorristaAuto) l)
                .orElseThrow(() -> new RuntimeException("No hay vehiculo socorrista para autos"));

        Auto auto = listaVehiculos.stream()
                .filter(l -> l instanceof Auto && l.getPatente().equals(patente))
                .findFirst()
                .map(l -> (Auto) l)
                .orElseThrow(() -> new RuntimeException("No hay autos con esa patente"));

        socorristaAuto.socorrer(auto);
    }

    public void socorrerMoto(String patente){
        SocorristaMoto socorristaMoto = listaSocorrista.stream()
                .filter(l -> l instanceof SocorristaMoto)
                .findAny()
                .map(l -> (SocorristaMoto) l)
                .orElseThrow(() -> new RuntimeException("No hay vehiculo socorrista para motos"));

        Moto moto = listaVehiculos.stream()
                .filter(l -> l instanceof Moto && l.getPatente().equals(patente))
                .findFirst()
                .map(l -> (Moto) l)
                .orElseThrow(() -> new RuntimeException("No hay motos con esa patente"));

        socorristaMoto.socorrer(moto);
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
