package Animales;

import interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerAnimal() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Comer un bife");
    }
}
