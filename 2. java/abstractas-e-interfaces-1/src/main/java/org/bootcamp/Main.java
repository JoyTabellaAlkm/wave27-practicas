package org.bootcamp;

import org.bootcamp.clients.Basic;
import org.bootcamp.clients.Cobrador;
import org.bootcamp.clients.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Ejecutivo jorgeEjecutivo = new Ejecutivo();
        Basic pedroBasico = new Basic();
        Cobrador juanCobrador = new Cobrador();

        jorgeEjecutivo.depositar(20_000);
        System.out.println();
        jorgeEjecutivo.transferir(5_000, "Pedro");
        System.out.println("\n");

        pedroBasico.consultar();
        System.out.println();
        pedroBasico.pagar("Netflix");
        System.out.println();
        pedroBasico.retirarEfectivo(1_000);
        System.out.println("\n");

        juanCobrador.retirarEfectivo(5_000);
        System.out.println();
        juanCobrador.consultar();
    }
}