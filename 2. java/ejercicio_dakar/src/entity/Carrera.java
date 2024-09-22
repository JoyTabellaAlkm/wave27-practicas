package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//Modelar la clase entity.Carrera que tiene los siguientes atributos:
//Distancia
//PremioEnDolares
//Nombre
//CantidadDeVehiculosPermitidos
//Lista de Vehiculos
public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
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

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "entity.Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadVehiculosPermitidos=" + cantidadVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                '}';
    }

    //Una carrera además tiene un conjunto de vehículos que participarán de la misma. Entonces, ahora la carrera va a tener
    // la responsabilidad de poder agregar a un vehículo, por lo que debemos definir los siguientes métodos:
    //public void darDeAltaAuto(velocidad,aceleracion,AnguloDeGiro,patente);
    //public void darDeAltaMoto(velocidad,aceleracion,AnguloDeGiro,patente);
    //Ambos métodos agregan un vehículo siempre y cuando haya cupo.
    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        int cantidad = getCantidadVehiculosPermitidos();
        if (cantidad > 0) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            setCantidadVehiculosPermitidos((cantidad-1));
        } else {
            System.out.println("Ya no se permiten mas vehiculos");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        int cantidad = getCantidadVehiculosPermitidos();
        if (cantidad > 0) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            setCantidadVehiculosPermitidos((cantidad-1));
        } else {
            System.out.println("Ya no se permiten mas vehiculos");
        }
    }

    //También vamos a tener la posibilidad de eliminar a un vehículo mediante dos métodos:
    //public void eliminarVehiculo(vehículo);
    //public void eliminarVehiculoConPatente(String unaPatente);
    public void eliminarVehiculo(Vehiculo vehiculo) {
        int cantidad = getCantidadVehiculosPermitidos();
        if (vehiculos.remove(vehiculo)) {
            System.out.println("Se ha eliminado el vehiculo satisfactoriamente");
            setCantidadVehiculosPermitidos((cantidad+1));
        } else {
            System.out.println("No se pudo eliminar el vehiculo");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        int cantidad = getCantidadVehiculosPermitidos();
        Optional<Vehiculo> vehiculo = vehiculos.stream().filter(v -> Objects.equals(v.getPatente(), unaPatente)).findFirst();
        if (vehiculo.isPresent()) {
            vehiculos.remove(vehiculo.get());
            System.out.println("Se ha eliminado el vehiculo satisfactoriamente");
            setCantidadVehiculosPermitidos((cantidad+1));
        } else {
            System.out.println("No se pudo eliminar el vehiculo");
        }
    }

    //Queremos poder definir el ganador de una carrera:
    //El ganador será aquel que tenga el máximo valor determinado por la siguiente fórmula:
    //Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
    public Vehiculo ganador() {
        double maximo = 0;
        Vehiculo vehiculoGanador = null;
        for (Vehiculo vehiculo : vehiculos) {
            double calculo = vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if (maximo == 0 || maximo < calculo) {
                maximo = calculo;
                vehiculoGanador = vehiculo;
            }
        }
        return vehiculoGanador;
    }

}
