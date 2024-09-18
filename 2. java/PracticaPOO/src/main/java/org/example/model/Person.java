package org.example.model;

public class Person {
    private String name;
    private int age;
    private String identificationNumber;
    private double weight;
    private double high;

    public Person() {
        this.name = "";
        this.age = 0;
        this.identificationNumber = "";
        this.weight = 0.0;
        this.high = 0.0;
    }

    public Person(String name, int age, String identificationNumber) {
        this.name = name;
        this.age = age;
        this.identificationNumber = identificationNumber;
    }

    public Person(String name, int age, String identificationNumber, double weight, double high) {
        this.name = name;
        this.age = age;
        this.identificationNumber = identificationNumber;
        this.weight = weight;
        this.high = high;
    }

    public int calculateIMC() {
        double imc = this.weight/(high*high);
        if(imc < 20) {
            return -1;
        } else if(imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }

    }

    public boolean isOverAge() {
        return this.age > 18;
    }

    @Override
    public String toString() {
        return  "Nombre: " + name + "\n" +
                "Edad: " + age + "\n" +
                "DNI: " + identificationNumber + "\n" +
                "Peso: " + weight + "\n" +
                "Estatura: " + high;
    }

}
