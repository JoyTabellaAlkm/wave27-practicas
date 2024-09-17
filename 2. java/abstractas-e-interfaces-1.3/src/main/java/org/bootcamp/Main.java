package org.bootcamp;

import org.bootcamp.animales.Animal;
import org.bootcamp.animales.Gato;
import org.bootcamp.animales.Perro;
import org.bootcamp.animales.Vaca;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        emitirSonidoAnimal(perro);
        emitirSonidoAnimal(gato);
        emitirSonidoAnimal(vaca);

        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }

    private static void comerAnimal(Animal animal) {
        animal.comer();
    }

    private static void emitirSonidoAnimal(Animal animal) {
        animal.emitirSonido();
    }
}