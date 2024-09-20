package org.example;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repositorio repositorioCliente = new Repositorio();

        Cliente cliente1 = new Cliente("Stephanie");
        Cliente cliente2 = new Cliente("Felipe");
        Cliente cliente3 = new Cliente("Mariany");
        Cliente cliente4 = new Cliente("Ana");
        Cliente cliente5 = new Cliente("Fernando");

        Localizador localizador = new Localizador(List.of(
                new ReservaHotel(new Date(), new Date(), 10000f, "Holiday Inn"),
                new ReservaComida(new Date(), new Date(), 15000f, "Restaurante Miami")),
                cliente1
        );

        System.out.println(localizador.getTotal());

    }
}