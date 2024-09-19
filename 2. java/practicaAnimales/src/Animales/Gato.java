package Animales;

import interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerAnimal() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo pescado");
    }
}
