package org.example;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Mati", "Gregorat", "433455");
        Cliente maria = new Cliente("Maria", "Fernandez", "435532");

        Reserva reserva1 = new Reserva("Paquete completo", "Tipo1");
        Reserva reserva2 = new Reserva("Hotel", "Tipo2");
        Reserva reserva3 = new Reserva("Boletos", "Tipo3");

        Localizador localizador1 = new Localizador(cliente1, List.of(reserva1), 2000.0);
        Localizador localizador2 = new Localizador(maria, List.of(reserva2, reserva2, reserva3, reserva3), 5000.0);

        ClienteRepositorio repositorio = new ClienteRepositorio();
        repositorio.saveLocalizador(localizador1);
        repositorio.saveLocalizador(localizador2);

        ClienteService service = new ClienteService(repositorio);

        double totalConDescuento1 = repositorio.aplicarDescuentos(localizador1);
        double totalConDescuento2 = repositorio.aplicarDescuentos(localizador2);

        System.out.println("Total con descuento para localizador1: " + totalConDescuento1);
        System.out.println("Total con descuento para localizador2: " + totalConDescuento2);

        service.cantidadLocalizadoresVendidos();
        service.cantidadReservasVendidas();
        service.totalDeVentas();
        service.promedioVentas();

    }
}