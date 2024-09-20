package org.example;

public class Main {
    public static void comerAnimal(Animal animal) {
        animal.comer();
    }

    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal vaca = new Vaca();
        Animal gato = new Gato();

        comerAnimal(perro);
        comerAnimal(vaca);
        comerAnimal(gato);
    }
}