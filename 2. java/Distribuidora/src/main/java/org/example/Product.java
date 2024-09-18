package org.example;

public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Nombre del Producto: " + name + "\n" +
                "Precio del Producto: " + price;
    }

    public double calculate(int qtyOfProducts) {
        return this.price * qtyOfProducts;
    }
}
