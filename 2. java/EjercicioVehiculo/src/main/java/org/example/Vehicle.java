package org.example;

public class Vehicle {

    private String model;
    private String brand;
    private Integer price;

    public Vehicle(String model, String brand, int price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Modelo: \"" + model + "\"\n" +
                "Marca: \"" + brand + "\"\n" +
                "Precio: " + price;
    }

}
