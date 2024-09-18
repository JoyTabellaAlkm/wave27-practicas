package org.example;

public class Distribuidora {
    public static void main(String[] args) {

        Product[] products = new Product[4];

        products[0] = new PerishableProduct("Leche", 1.5,2);
        products[1] = new PerishableProduct("Pan", 1.0,1);
        products[2] = new NonPerishableProduct("Arroz", 2.0, "Grano");
        products[3] = new NonPerishableProduct("Lentejas", 2.5, "Legumbre");

        int qtyToDelete = 5;

        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.calculate(qtyToDelete);
        }

        System.out.print("El precio total al vender " + qtyToDelete + " productos de cada tipo es: " + String.format("%.2f", totalPrice));

    }
}