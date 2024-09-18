package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        System.out.println("Ingrese el valor inicial");
        int initialValue = scan.nextInt();
        TwoSeries twoSeries = new TwoSeries(initialValue);
        System.out.println("El Valor inicial es: " + twoSeries.getInitialValue());
        System.out.println("El siguiente valor en la serie es: " + twoSeries.nextValue(initialValue));
        System.out.println("Reiniciando la serie nos queda como valor inicial: " + twoSeries.rebootSerie());

    }
}