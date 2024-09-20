package org.example;

import org.example.entidades.Basic;
import org.example.entidades.Cliente;
import org.example.entidades.Cobrador;
import org.example.entidades.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Cliente cliente1 = new Cobrador();
        Cliente cliente2 = new Ejecutivo();
        Cliente cliente3 = new Basic();

        
    }
}